package com.kotlintemplates.DiffUtilList.ViewModel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.kotlintemplates.DiffUtilList.Model.DiffUtilModel
import com.kotlintemplates.DiffUtilList.Repository.StudentRepository
import com.kotlintemplates.Login.repository.ValidationRepository

class DiffUtilViewModel : AndroidViewModel {
    private var studentRepository : StudentRepository

    constructor(application: Application) : super(application){
            studentRepository = StudentRepository(application)
    }

    fun insertInToRepository(postStudentInfo: DiffUtilModel?){
        studentRepository.insertDataToFireBase(postStudentInfo)
    }

   /* fun fetchStudentInfoFromFireBase():LiveData<MutableList<DiffUtilModel>>{
        return  studentRepository.fetchStudentData()
    }*/
}