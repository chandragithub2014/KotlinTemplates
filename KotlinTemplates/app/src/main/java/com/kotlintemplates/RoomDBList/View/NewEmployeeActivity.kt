package com.kotlintemplates.RoomDBList.View

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.kotlintemplates.R
import com.kotlintemplates.SimpleLazyList.Views.SimpleLazyListFragment

class NewEmployeeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_employee)
        supportFragmentManager.beginTransaction().replace(R.id.container_newemp, NewEmployeeFragment()).commit()
    }
}

