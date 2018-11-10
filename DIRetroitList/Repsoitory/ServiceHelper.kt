package com.kotlintemplates.DIRetroitList.Repsoitory

import android.app.Application
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.content.Context
import android.util.Log
import com.kotlintemplates.DIRetroitList.Model.RetroModel
import com.kotlintemplates.DIRetroitList.Repository.APIService
import com.kotlintemplates.KotlinTemplateApplication
import com.kotlintemplates.RoomRetrofitList.Repository.ResultModel
import retrofit2.Retrofit
import javax.inject.Inject
import com.kotlintemplates.MainActivity
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception
import java.util.ArrayList


class ServiceHelper {
/*
@Inject
lateinit var apiService: APIService
*/


    fun providesWebService(apiService: APIService): LiveData<List<RetroModel>> {
        val data = MutableLiveData<List<RetroModel>>()
        var webserviceResponseList: List<RetroModel>
        try {
         //   KotlinTemplateApplication.instance.fetchRetroComponent().inject(this@ServiceHelper)
       //     KotlinTemplateApplication.instance.fetchRetroComponent().inject(ServiceHelper())
          //  var retrofitServiceInterface: APIService = retrofit.create(APIService::class.java)

            apiService.makeRequest().enqueue(object : Callback<String> {
                override fun onResponse(call: Call<String>, response: Response<String>) {
                    Log.d("Repository", "Response::::" + response.body()!!)
                    webserviceResponseList = parseJson(response.body())
                    data.setValue(webserviceResponseList)
                }

                override fun onFailure(call: Call<String>, t: Throwable) {
                    Log.d("Repository", "Failed:::")
                }
            })
        }catch (e:Exception){
            e.printStackTrace()
        }
        return data

    }


    private fun parseJson(response: String?): List<RetroModel> {

        val apiResults = ArrayList<RetroModel>()

        val jsonObject: JSONObject

        val jsonArray: JSONArray

        try {
            jsonArray = JSONArray(response)

            for (i in 0 until jsonArray.length()) {
                var jsonInfo: JSONObject = jsonArray.getJSONObject(i)

                val mMovieModel = RetroModel(Integer.parseInt(jsonInfo.getString("id")),
                        jsonInfo.getString("title"),
                        jsonInfo.getString("body")
                        )
                //mMovieModel.setId(object.getString("id"));
            /*    mMovieModel.setId(Integer.parseInt(jsonInfo.getString("id")))
                mMovieModel.setTitle(jsonInfo.getString("title"))
                mMovieModel.setBody(jsonInfo.getString("body"))*/

                apiResults.add(mMovieModel)
            }


        } catch (e: JSONException) {
            e.printStackTrace()
        }

        Log.i(javaClass.simpleName, apiResults.size.toString())
        return apiResults

    }
}