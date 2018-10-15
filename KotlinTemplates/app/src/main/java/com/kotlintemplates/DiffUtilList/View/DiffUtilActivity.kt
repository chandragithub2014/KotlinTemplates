package com.kotlintemplates.DiffUtilList.View

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.kotlintemplates.Login.view.LoginFragment
import com.kotlintemplates.R

class DiffUtilActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diff_util)
        supportFragmentManager.beginTransaction().replace(R.id.container_difList, DiffUtilFragment()).commit()
    }
}

