package com.kotlintemplates.DIRecyclerView.DI

import com.kotlintemplates.DIRecyclerView.Repository.WebServiceHelper
import com.kotlintemplates.DIRecyclerView.View.DaggerListFragment
import com.kotlintemplates.DIRecyclerView.View.RetroDIListActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(RetroModule::class))

interface RetroComponent {
    fun inject(retroDIListActivity: RetroDIListActivity)
    fun inject(daggerListFragment: DaggerListFragment)
   // fun inject(webServiceHelper: WebServiceHelper)
}