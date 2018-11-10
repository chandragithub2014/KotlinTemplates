package com.kotlintemplates.DIRetroitList.ViewModel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import android.os.AsyncTask
import com.kotlintemplates.DIRetroitList.Model.RetroModel
import com.kotlintemplates.DIRetroitList.Repository.APIService
import com.kotlintemplates.DIRetroitList.Repsoitory.ServiceHelper
import com.kotlintemplates.RoomRetrofitList.Repository.APIServiceFactory
import com.kotlintemplates.RoomRetrofitList.Repository.PostInfoDBRepository
import com.kotlintemplates.RoomRetrofitList.Repository.ResultModel
import javax.inject.Inject


class RetroDIListViewModel:AndroidViewModel {

   // private  var postInfoDBRepository: PostInfoDBRepository
    private  var webServiceRepository: ServiceHelper
    private  lateinit var retroObservable: LiveData<List<RetroModel>>

  //  private  var mAllPosts: LiveData<List<ResultModel>>


    constructor(application: Application) : super(application){
  //      postInfoDBRepository = PostInfoDBRepository(application)
        webServiceRepository = ServiceHelper()
     //   retroObservable = webServiceRepository.providesWebService()
      //  postInfoDBRepository.insertPost(retroObservable.value)
        // mAllPosts  = postInfoDBRepository.getAllPosts()
    }

   /* fun getAllPosts(): LiveData<List<ResultModel>> {
        return mAllPosts
    }*/


    fun fetchPostsFromWebSevice(apiService: APIService):LiveData<List<RetroModel>>{
        retroObservable =webServiceRepository.providesWebService(apiService)
        return retroObservable
    }

 /*   fun insertAllPosts(postLists: List<ResultModel>?){
        if(retroObservable.value!=null) {
            postInfoDBRepository.insertPost(postLists)
        }
    }*/


}