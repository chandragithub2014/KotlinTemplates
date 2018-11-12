package com.kotlintemplates.DIRecyclerView.Repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.kotlintemplates.RoomRetrofitList.Repository.APIService
import com.kotlintemplates.RoomRetrofitList.Repository.ResultModel
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import java.util.ArrayList

class WebServiceHelper {


    fun providesWebService(retrofit: Retrofit): LiveData<List<ResultModel>> {
        val data = MutableLiveData<List<ResultModel>>()
        var webserviceResponseList: List<ResultModel>
        try{
            val service = retrofit.create(APIService::class.java)
            //  response = service.makeRequest().execute().body();
            service.makeRequest().enqueue(object : Callback<String> {
                override fun onResponse(call: Call<String>, response: Response<String>) {
                    Log.d("Repository", "Response::::" + response.body()!!)
                    webserviceResponseList = parseJson(response.body())
                    data.setValue(webserviceResponseList)
                }

                override fun onFailure(call: Call<String>, t: Throwable) {
                    Log.d("Repository", "Failed:::")
                }
            })
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return data
    }

    private fun parseJson(response: String?): List<ResultModel> {

        val apiResults = ArrayList<ResultModel>()

        val jsonObject: JSONObject

        val jsonArray: JSONArray

        try {
            jsonArray = JSONArray(response)

            for (i in 0 until jsonArray.length()) {
                var jsonInfo: JSONObject = jsonArray.getJSONObject(i)

                val mMovieModel = ResultModel()
                //mMovieModel.setId(object.getString("id"));
                mMovieModel.setId(Integer.parseInt(jsonInfo.getString("id")))
                mMovieModel.setTitle(jsonInfo.getString("title"))
                mMovieModel.setBody(jsonInfo.getString("body"))

                apiResults.add(mMovieModel)
            }


        } catch (e: JSONException) {
            e.printStackTrace()
        }

        Log.i(javaClass.simpleName, apiResults.size.toString())
        return apiResults

    }
}