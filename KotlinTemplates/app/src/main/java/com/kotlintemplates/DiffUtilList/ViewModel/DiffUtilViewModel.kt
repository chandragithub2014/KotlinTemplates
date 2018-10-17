package com.kotlintemplates.DiffUtilList.ViewModel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.google.firebase.database.*
import com.kotlintemplates.DiffUtilList.Model.DiffUtilModel
import com.kotlintemplates.DiffUtilList.Repository.StudentRepository
import com.kotlintemplates.Login.repository.ValidationRepository

class DiffUtilViewModel : AndroidViewModel {
    private var studentRepository : StudentRepository
    lateinit var dataBaseReference: DatabaseReference

    constructor(application: Application) : super(application){
            studentRepository = StudentRepository(application)
           dataBaseReference = FirebaseDatabase.getInstance().getReference("students")
    }

    fun insertInToRepository(postStudentInfo: DiffUtilModel?){
        studentRepository.insertDataToFireBase(postStudentInfo)
    }

   /* fun fetchStudentInfoFromFireBase():LiveData<MutableList<DiffUtilModel>>{
        return  studentRepository.fetchStudentData()
    }*/

    fun fetchStudentInfoFromFireBase():LiveData<List<DiffUtilModel>>{
        var studentList:MutableList<DiffUtilModel>
        val data = MutableLiveData<List<DiffUtilModel>>()
        dataBaseReference.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {
                studentList  = mutableListOf()
                for (studentSnapShot in p0!!.getChildren()) {
                    studentList!!.add(studentSnapShot.getValue(DiffUtilModel::class.java)!!)
                }
                if(studentList!!.size>0){
                    data.value = studentList
                    Log.d("DiffUtilragment","StudentList Size:::"+studentList!!.size)
                    for (i in 0 until studentList!!.size) {
                        val diffUtilModel:DiffUtilModel = studentList!!.get(i)
                        Log.d("DiffUtilFragment",diffUtilModel.registrationId)
                    }
                }
            }
        });
        return data;
    }
}