package com.kotlintemplates.RoomDBList.View

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.kotlintemplates.R

class RoomDBListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_dblist)
        supportFragmentManager.beginTransaction().replace(R.id.container_roomdblist, RoomDBDiUtilListFragment()).commit()
    }
}
