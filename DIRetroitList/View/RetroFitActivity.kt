package com.kotlintemplates.DIRetroitList.View

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.kotlintemplates.R
import com.kotlintemplates.RoomRetrofitList.View.RetrofitRoomKotlinFragment

class RetroFitActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retro_fit)
        supportFragmentManager.beginTransaction().replace(R.id.container_retro_di, RetroDIFragment()).commit()
    }
}
