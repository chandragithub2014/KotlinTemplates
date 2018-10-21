package com.kotlintemplates.GridList.View

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.kotlintemplates.R
import com.kotlintemplates.SimpleLazyList.Views.SimpleLazyListFragment

class GridListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_list)
        supportFragmentManager.beginTransaction().replace(R.id.container_gridlist, GridListFragment()).commit()
    }
}
