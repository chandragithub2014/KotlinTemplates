package com.kotlintemplates.DIRecyclerView.DI

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class RetroModule(var urlPath:String) {
    init{
        this.urlPath = urlPath
    }

   @Singleton
   @Provides
    fun provideGson() : Gson{
        var gsonBuilder = GsonBuilder()
        return gsonBuilder.create()
    }
    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson):Retrofit{
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