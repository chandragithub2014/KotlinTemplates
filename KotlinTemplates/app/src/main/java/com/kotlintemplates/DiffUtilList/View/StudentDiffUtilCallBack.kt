package com.kotlintemplates.DiffUtilList.View

import android.content.Context
import android.support.v7.util.DiffUtil
import com.kotlintemplates.DiffUtilList.Model.DiffUtilModel
import com.kotlintemplates.Launcher.interfaces.ClickListener

class StudentDiffUtilCallBack(val oldStudentList: MutableList<DiffUtilModel>, val newStudentList: MutableList<DiffUtilModel>) : DiffUtil.Callback() {


    override fun areContentsTheSame(p0: Int, p1: Int): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun areItemsTheSame(p0: Int, p1: Int): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getNewListSize(): Int {
         return newStudentList.size
    }

    override fun getOldListSize(): Int {
        return oldStudentList.size
    }


}