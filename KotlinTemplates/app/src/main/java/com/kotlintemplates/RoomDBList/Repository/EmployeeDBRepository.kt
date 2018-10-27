package com.kotlintemplates.RoomDBList.Repository

import android.app.Application
import android.arch.lifecycle.LiveData
import android.os.AsyncTask
import com.kotlintemplates.RoomDBList.Model.EmployeeEntity
import com.kotlintemplates.RoomDBList.Model.EmplyoeeDao
import com.kotlintemplates.RoomDBList.Model.EmplyoeeDataBase

class EmployeeDBRepository {
    var emplyoeeDao:EmplyoeeDao
    private  var mAllEmps: LiveData<List<EmployeeEntity>>

     constructor(application: Application){
        val db = EmplyoeeDataBase.getInstance(application)
        emplyoeeDao = db!!.employeeDao()
         mAllEmps   = emplyoeeDao.getAllEmployeeDetails()
    }

    fun getAllEmps(): LiveData<List<EmployeeEntity>> {
        return mAllEmps
    }

    fun insertEmp(emp:EmployeeEntity){
        InsertEmpAsyncTask(emplyoeeDao).execute(emp)
    }


    fun insertEmpList(empLists: List<EmployeeEntity>?) {
        InsertAsyncTask(emplyoeeDao).execute(empLists)
    }


    class InsertAsyncTask internal  constructor(postInfoDao: EmplyoeeDao): AsyncTask<List<EmployeeEntity>, Void, Void>(){
        private  var mAsyncUserDao: EmplyoeeDao
        init {
            mAsyncUserDao = postInfoDao
        }
        override fun doInBackground(vararg p0: List<EmployeeEntity>): Void? {
            if(p0[0]!=null) {
                mAsyncUserDao.insertEmps(p0[0])
            }
            return null

        }
    }

    class InsertEmpAsyncTask internal  constructor(postInfoDao: EmplyoeeDao): AsyncTask<EmployeeEntity, Void, Void>(){
        private  var mAsyncUserDao: EmplyoeeDao
        init {
            mAsyncUserDao = postInfoDao
        }
        override fun doInBackground(vararg p0: EmployeeEntity): Void? {
            if(p0[0]!=null) {
                mAsyncUserDao.insert(p0[0])
            }
            return null

        }
    }
}