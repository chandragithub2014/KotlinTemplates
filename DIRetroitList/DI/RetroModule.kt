package com.kotlintemplates.DIRetroitList.DI

import com.kotlintemplates.DIRetroitList.Repository.APIService
import com.kotlintemplates.RoomRetrofitList.Repository.APIURL
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
public class RetroModule(var urlPath:String) {

// var urlPath:String
    init{
        this.urlPath  = urlPath
    }

    @Singleton
    @Provides
    fun provideServiceAPI(retrofit: Retrofit):APIService{
        return retrofit.create(APIService::class.java)
    }

    @Singleton
    @Provides
    fun provideRetrofit():Retrofit{
        val retrofit = Retrofit.Builder()
                .baseUrl(urlPath)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(providesOkHttpClientBuilder())
                .build()
        return  retrofit

    }


    private fun providesOkHttpClientBuilder(): OkHttpClient {

        val httpClient = OkHttpClient.Builder()
        return httpClient.readTimeout(1200, TimeUnit.SECONDS)
                .connectTimeout(1200, TimeUnit.SECONDS).build()

    }
}