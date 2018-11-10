package com.kotlintemplates.DIRetroitList.DI

import com.kotlintemplates.DIRetroitList.Repsoitory.ServiceHelper
import com.kotlintemplates.DIRetroitList.View.RetroDIFragment
import com.kotlintemplates.DIRetroitList.ViewModel.RetroDIListViewModel
import com.kotlintemplates.KotlinTemplateApplication
import dagger.Component
import javax.inject.Singleton
import com.kotlintemplates.MainActivity
import android.app.Application
import dagger.BindsInstance




@Singleton
@Component(modules = arrayOf(RetroModule::class,FragmentModule::class))
interface RetroComponent{
    /*@Component.Builder
     interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): RetroComponent
    }*/
    fun inject(retroDIFragment: RetroDIFragment)
    //fun inject(kotlinTemplateApplication: KotlinTemplateApplication)
}