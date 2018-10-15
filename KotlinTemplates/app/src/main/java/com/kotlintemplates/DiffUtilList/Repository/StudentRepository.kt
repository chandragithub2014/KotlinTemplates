package com.kotlintemplates.DiffUtilList.Repository

import android.app.Application
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.google.firebase.database.*
import com.kotlintemplates.DiffUtilList.Model.DiffUtilModel
import java.util.ArrayList
import com.google.firebase.database.ValueEventListener



class StudentRepository(application: Application) {
    var application:Application
    lateinit var dataBaseReference: DatabaseReference
    private  var studentInfoList: LiveData<MutableList<DiffUtilModel>>?=null


    init {
        this.application = application
        dataBaseReference = FirebaseDatabase.getInstance().getReference("students")
    }

    fun insertDataToFireBase(postStudentInfo: DiffUtilModel?){
        dataBaseReference.child(postStudentInfo!!.registrationId).setValue(postStudentInfo)
    }


}