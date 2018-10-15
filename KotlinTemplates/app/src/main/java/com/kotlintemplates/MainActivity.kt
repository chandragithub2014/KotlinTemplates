package com.kotlintemplates

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.kotlintemplates.Launcher.View.TemplateListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        launchInitialFragment()
    }


    private fun launchInitialFragment(){
        supportFragmentManager.beginTransaction().replace(R.id.container_templates, TemplateListFragment()).commit()
    }
}
