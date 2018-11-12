package com.kotlintemplates.DIRecyclerView

import android.app.Application
import com.kotlintemplates.DIRecyclerView.DI.DaggerRetroComponent
import com.kotlintemplates.DIRecyclerView.DI.RetroComponent
import com.kotlintemplates.DIRecyclerView.DI.RetroModule
import com.kotlintemplates.DInjection.View.DI.DaggerNetworkComponent
import com.kotlintemplates.DInjection.View.DI.NetworkModule
import com.kotlintemplates.DInjection.View.Repository.HelperURL

class RetroDIApplication:Application() {
  lateinit var retroComponent:RetroComponent
    override fun onCreate() {
        super.onCreate()
        retroComponent = DaggerRetroComponent.builder()
                .retroModule(RetroModule(HelperURL.BASE_URL))
                .build()
    }



    fun fetchRetroComponent():RetroComponent{
        return  retroComponent
    }
}