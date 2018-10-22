package com.kotlintemplates.RoomRetrofitList.View

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.kotlintemplates.R


class RetroRoomActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retro_room)
        supportFragmentManager.beginTransaction().replace(R.id.container_retro_room, RetrofitRoomKotlinFragment()).commit()
    }
}
