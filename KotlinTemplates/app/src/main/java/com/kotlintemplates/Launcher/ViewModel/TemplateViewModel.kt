package com.kotlintemplates.Launcher.ViewModel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.kotlintemplates.Launcher.Model.TemplateModel

class TemplateViewModel : AndroidViewModel {

    constructor(application: Application):super(application){

    }


    fun fetchTemplateList(): LiveData<List<TemplateModel>> {
        val data = MutableLiveData<List<TemplateModel>>()
        data.value = temlpateList.templateInfo
        return data
    }


    object temlpateList{
        val templateInfo = listOf(
                TemplateModel("Login"),
                TemplateModel("DiffUtilDBList"),
                TemplateModel("Simple Lazy List"),
                TemplateModel("Grid Lazy List"),
                TemplateModel("WebService DB List"),
                TemplateModel("Tab"),
                TemplateModel("RoomDBForm"),
                TemplateModel("DiffUtilListFireBase"),
                TemplateModel("DaggerRetroFITList"),
                TemplateModel("Registration Form"),
                TemplateModel("SlidingMenu")/*,
                TemplateModel("SlidingMenuType2")*/



                //TemplateModel("RoomDBList"),
        )
    }
}