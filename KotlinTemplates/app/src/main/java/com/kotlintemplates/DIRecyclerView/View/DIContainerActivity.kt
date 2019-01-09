package com.kotlintemplates.DIRecyclerView.View

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.kotlintemplates.R
import com.kotlintemplates.SimpleLazyList.Views.SimpleLazyListFragment

class DIContainerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dicontainer)
        supportFragmentManager.beginTransaction().replace(R.id.container_dagger, DaggerListFragment()).commit()
    }
}
