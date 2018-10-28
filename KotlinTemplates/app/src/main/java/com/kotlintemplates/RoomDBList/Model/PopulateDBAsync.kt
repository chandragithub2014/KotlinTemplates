package com.kotlintemplates.RoomDBList.Model

import android.os.AsyncTask


    class PopulateDbAsync internal constructor(db: EmplyoeeDataBase) : AsyncTask<Void, Void, Void>() {

        private val mDao: EmplyoeeDao

        init {
            mDao = db.employeeDao()
        }

        override fun doInBackground(vararg params: Void): Void? {
         //   mDao.deleteAll()
            return null
        }
    }
