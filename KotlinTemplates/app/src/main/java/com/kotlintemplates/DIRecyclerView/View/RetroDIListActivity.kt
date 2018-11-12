package com.kotlintemplates.DIRecyclerView.View

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import com.kotlintemplates.DIRecyclerView.RetroDIApplication
import com.kotlintemplates.DIRecyclerView.ViewModel.RetroDIViewModel
import com.kotlintemplates.DInjection.View.CustomApplication
import com.kotlintemplates.DInjection.View.Repository.APIService
import com.kotlintemplates.R
import com.kotlintemplates.RoomRetrofitList.Repository.ResultModel
import com.kotlintemplates.RoomRetrofitList.View.PostsAdapter
import com.kotlintemplates.RoomRetrofitList.ViewModel.PostListViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

class RetroDIListActivity : AppCompatActivity() {
    @Inject
    lateinit var retrofit: Retrofit
    lateinit var retroDIViewModel: RetroDIViewModel
    lateinit var retrofitDIRecyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retro_dilist)
        retroDIViewModel = ViewModelProviders.of(this).get(RetroDIViewModel::class.java)
        initViews()
        setAdapter()
        (application as RetroDIApplication).retroComponent.inject(this@RetroDIListActivity)
        /*  val mService = retrofit!!.create(APIService::class.java)
        val mInfo = mService.makeRequest()
         mInfo.enqueue(object : Callback<String> {
             override fun onResponse(call: Call<String>, response: Response<String>) {
                 Log.d("DIActivity", "Response::::" + response.body())
             }

             override fun onFailure(call: Call<String>, t: Throwable) {
                 Log.d("DIActivity", "Error Response::::" + t.toString())
             }
         })*/

        retroDIViewModel.fetchPostsFromWebSevice(retrofit).observe(this,object : Observer<List<ResultModel>> {

            override fun onChanged(t: List<ResultModel>?) {
                userPostAdapter.setListItems(t)

            }
        })

    }


    private fun initViews(){
        retrofitDIRecyclerView = findViewById<RecyclerView>(R.id.retro_di_list)as RecyclerView
    }


    lateinit var userPostAdapter: PostsAdapter
    private  fun setAdapter(){

        userPostAdapter = PostsAdapter()
        retrofitDIRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        retrofitDIRecyclerView.adapter = userPostAdapter

    }
}
