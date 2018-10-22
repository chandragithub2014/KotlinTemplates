package com.kotlintemplates.RoomRetrofitList.ViewModel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import android.os.AsyncTask
import com.kotlintemplates.RoomRetrofitList.Repository.APIServiceFactory
import com.kotlintemplates.RoomRetrofitList.Repository.PostInfoDBRepository
import com.kotlintemplates.RoomRetrofitList.Repository.ResultModel



class PostListViewModel:AndroidViewModel {

    private  var postInfoDBRepository: PostInfoDBRepository
    private  var webServiceRepository: APIServiceFactory
    private  lateinit var retroObservable: LiveData<List<ResultModel>>
    private  var mAllPosts: LiveData<List<ResultModel>>


    constructor(application: Application) : super(application){
        postInfoDBRepository = PostInfoDBRepository(application)
        webServiceRepository = APIServiceFactory()
     //   retroObservable = webServiceRepository.providesWebService()
      //  postInfoDBRepository.insertPost(retroObservable.value)
         mAllPosts  = postInfoDBRepository.getAllPosts()
    }

    fun getAllPosts(): LiveData<List<ResultModel>> {
        return mAllPosts
    }


    fun fetchPostsFromWebSevice():LiveData<List<ResultModel>>{
        retroObservable =webServiceRepository.providesWebService()
        return retroObservable
    }

    fun insertAllPosts(postLists: List<ResultModel>?){
        if(retroObservable.value!=null) {
            postInfoDBRepository.insertPost(postLists)
        }
    }


}