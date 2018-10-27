package com.kotlintemplates.RoomDBList.ViewModel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import android.os.AsyncTask
import com.kotlintemplates.RoomDBList.Model.EmployeeEntity
import com.kotlintemplates.RoomDBList.Repository.EmployeeDBRepository
import com.kotlintemplates.RoomRetrofitList.Repository.APIServiceFactory
import com.kotlintemplates.RoomRetrofitList.Repository.PostInfoDBRepository
import com.kotlintemplates.RoomRetrofitList.Repository.ResultModel



class RoomDBViewModel:AndroidViewModel {

    private var employeeDBRepository:EmployeeDBRepository

    private  lateinit var retroObservable: LiveData<List<ResultModel>>
    private  var mAllEmpList: LiveData<List<EmployeeEntity>>


    constructor(application: Application) : super(application){
        employeeDBRepository = EmployeeDBRepository(application)
        mAllEmpList  = employeeDBRepository.getAllEmps()
    }

    fun getAllEmps(): LiveData<List<EmployeeEntity>> {
        return mAllEmpList
    }


    fun insertEmpInfo(employeeEntity: EmployeeEntity){
       employeeDBRepository.insertEmp(employeeEntity)
   }




}