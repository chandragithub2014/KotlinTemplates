package com.kotlintemplates.RoomRetrofitList.Repository

import android.os.AsyncTask


    class PopulateDbAsync internal constructor(db: PostInfoRoomDataBase) : AsyncTask<Void, Void, Void>() {

        private val mDao: PostInfoDao

        init {
            mDao = db.postInfoDao()
        }

        override fun doInBackground(vararg params: Void): Void? {
            mDao.deleteAll()
            return null
        }
    }
