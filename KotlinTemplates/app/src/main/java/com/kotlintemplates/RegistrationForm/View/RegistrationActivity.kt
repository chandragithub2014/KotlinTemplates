package com.kotlintemplates.RegistrationForm.View

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.kotlintemplates.Login.view.LoginFragment
import com.kotlintemplates.R

class RegistrationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        supportFragmentManager.beginTransaction().replace(R.id.container_registration, EmployeeRegistrationFragment()).commit()
    }
}
