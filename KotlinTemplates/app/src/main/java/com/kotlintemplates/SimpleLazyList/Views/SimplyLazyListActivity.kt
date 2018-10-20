package com.kotlintemplates.SimpleLazyList.Views

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.kotlintemplates.DiffUtilList.View.DiffUtilFragment
import com.kotlintemplates.R

class SimplyLazyListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simply_lazy_list)
        supportFragmentManager.beginTransaction().replace(R.id.container_lazylist, SimpleLazyListFragment()).commit()
    }
}

