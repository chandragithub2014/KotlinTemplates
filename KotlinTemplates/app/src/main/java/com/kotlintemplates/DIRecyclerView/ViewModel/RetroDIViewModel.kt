package com.kotlintemplates.DIRecyclerView.ViewModel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.kotlintemplates.DIRecyclerView.Repository.WebServiceHelper
import com.kotlintemplates.RoomRetrofitList.Repository.ResultModel
import retrofit2.Retrofit

class RetroDIViewModel: AndroidViewModel {

    private var webServiceHelper:WebServiceHelper
    private  lateinit var retroObservable: LiveData<List<ResultModel>>
    constructor(application: Application) : super(application){
        webServiceHelper  = WebServiceHelper()
    }
    fun fetchPostsFromWebSevice(retrofit: Retrofit): LiveData<List<ResultModel>> {
        retroObservable =webServiceHelper.providesWebService(retrofit)
        return retroObservable
    }
}