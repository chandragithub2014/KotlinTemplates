package com.kotlintemplates.DInjection.View.DI;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

@Module
public class NetworkModule {
    private String urlPath;
    public NetworkModule(String urlPath) {
        this.urlPath = urlPath;
    }
    @Singleton
    @Provides
    public Gson provideGson(){
        GsonBuilder builder = new GsonBuilder();
        return builder.create();
    }
    @Singleton
    @Provides
    public Retrofit provideRetrofit(Gson gson){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(urlPath)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(providesOkHttpClientBuilder())
                .build();
        return retrofit;
    }


    private OkHttpClient providesOkHttpClientBuilder(){
        OkHttpClient httpClient = new OkHttpClient();
        return  httpClient.newBuilder().readTimeout(1200, TimeUnit.SECONDS)
                .connectTimeout(1200, TimeUnit.SECONDS).build();

    }

}