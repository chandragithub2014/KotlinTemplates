package com.kotlintemplates.DiffUtilList.View

import android.content.Context
import android.support.v7.util.DiffUtil
import com.kotlintemplates.DiffUtilList.Model.DiffUtilModel
import com.kotlintemplates.Launcher.interfaces.ClickListener

class StudentDiffUtilCallBack(val oldStudentList: MutableList<DiffUtilModel>, val newStudentList: MutableList<DiffUtilModel>) : DiffUtil.Callback() {


    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
       val oldStudent:DiffUtilModel = oldStudentList.get(oldItemPosition);
        val newStudent:DiffUtilModel = newStudentList.get(newItemPosition);

        return oldStudent.firstName.equals(newStudent.firstName)
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldStudentList.get(oldItemPosition).registrationId == newStudentList.get(
                newItemPosition).registrationId
    }

    override fun getNewListSize(): Int {
         return newStudentList.size
    }

    override fun getOldListSize(): Int {
        return oldStudentList.size
    }


}