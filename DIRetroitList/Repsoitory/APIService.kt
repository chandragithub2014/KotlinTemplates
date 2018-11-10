package com.kotlintemplates.DIRetroitList.Repository

import retrofit2.Call
import retrofit2.http.GET

public interface APIService {
    @GET("posts")
    abstract fun makeRequest(): Call<String>
}