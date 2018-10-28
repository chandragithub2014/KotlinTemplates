package com.kotlintemplates.RoomDBList.View

import android.content.Context
import android.support.v7.util.DiffUtil
import com.kotlintemplates.DiffUtilList.Model.DiffUtilModel
import com.kotlintemplates.Launcher.interfaces.ClickListener
import com.kotlintemplates.RoomDBList.Model.EmployeeEntity

class EmpDiffUtilCallBack(val oldStudentList: MutableList<EmployeeEntity>, val newStudentList: MutableList<EmployeeEntity>) : DiffUtil.Callback() {


    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
       val oldStudent:EmployeeEntity = oldStudentList.get(oldItemPosition);
        val newStudent:EmployeeEntity = newStudentList.get(newItemPosition);

        return oldStudent.empName!!.equals(newStudent.empName)
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldStudentList.get(oldItemPosition).id == newStudentList.get(
                newItemPosition).id
    }

    override fun getNewListSize(): Int {
         return newStudentList.size
    }

    override fun getOldListSize(): Int {
        return oldStudentList.size
    }


}