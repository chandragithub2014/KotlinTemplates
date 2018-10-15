package com.kotlintemplates.Utils

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

class ExtensionUtils {

     fun Context.showToast(message:String, duration:Int = Toast.LENGTH_SHORT){
       Toast.makeText(this,message,duration)
    }
}