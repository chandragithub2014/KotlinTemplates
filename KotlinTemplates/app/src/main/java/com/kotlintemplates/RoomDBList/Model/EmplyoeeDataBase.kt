package com.kotlintemplates.RoomDBList.Model

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = arrayOf(EmployeeEntity::class), version = 1)

abstract class EmplyoeeDataBase : RoomDatabase() {

       abstract  fun employeeDao() : EmplyoeeDao

      companion object {
          private  var INSTANCE : EmplyoeeDataBase?=null
          fun getInstance(context:Context):EmplyoeeDataBase?{
              if(INSTANCE == null){
                  synchronized(EmplyoeeDataBase::class){
                      INSTANCE = Room.databaseBuilder(context.applicationContext,EmplyoeeDataBase::class.java,"EmployeeInfo.db").build()
                  }
              }
              return INSTANCE
          }

          fun destroyInstance() {
              INSTANCE = null
          }

          val sRoomDataBaseCallback = object:RoomDatabase.Callback(){
              override fun onOpen(db: SupportSQLiteDatabase) {
                  super.onOpen(db)
                  PopulateDbAsync(INSTANCE!!).execute()
              }
          };
      }
}
