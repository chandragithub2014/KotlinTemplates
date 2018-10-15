package com.kotlintemplates.Login.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.kotlintemplates.Launcher.View.TemplateListFragment
import com.kotlintemplates.R

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportFragmentManager.beginTransaction().replace(R.id.container_login, LoginFragment()).commit()
    }
}

