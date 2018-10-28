package com.kotlintemplates.RoomDBList.View

import android.content.Context
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kotlintemplates.DiffUtilList.Model.DiffUtilModel
import com.kotlintemplates.Launcher.Model.TemplateModel
import com.kotlintemplates.Launcher.ViewModel.TemplateViewModel
import com.kotlintemplates.Launcher.interfaces.ClickListener
import com.kotlintemplates.R
import com.kotlintemplates.RoomDBList.Model.EmployeeEntity
import kotlinx.android.synthetic.main.diff_util_list_item.view.*
import kotlinx.android.synthetic.main.fragment_new_employee.view.*
import kotlinx.android.synthetic.main.room_db_list_item.view.*


class RoomDBAdapter(val context: Context, val clickListener: ClickListener ) : RecyclerView.Adapter<RoomDBAdapter.DiffUtilViewHolder>(){

  // private var  diffUtilModelList:MutableList<DiffUtilModel>?= MutableList<DiffUtilModel>()
     var diffUtilModelList = mutableListOf<EmployeeEntity>()

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): DiffUtilViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.room_db_list_item,p0,false)
        return DiffUtilViewHolder(view)
    }


    override fun onBindViewHolder(DiffUtilViewHolder: DiffUtilViewHolder, pos: Int) {
       val templateInfo = diffUtilModelList!!.get(pos) //diffUtilModelList!![pos]
       DiffUtilViewHolder.setData(templateInfo,pos)


    }

     fun setListInfo(diffUtilModelList: MutableList<EmployeeEntity>){
       this.diffUtilModelList = diffUtilModelList
       notifyDataSetChanged()
    }

     fun updateStudentInfo(updatedDiffUtilModelList: List<EmployeeEntity>){
        val empDiffUtilCallBack:EmpDiffUtilCallBack = EmpDiffUtilCallBack(diffUtilModelList!!,updatedDiffUtilModelList.toMutableList())
         val diffResult:DiffUtil.DiffResult = DiffUtil.calculateDiff(empDiffUtilCallBack)
         this.diffUtilModelList!!.clear()
         this.diffUtilModelList!!.addAll(updatedDiffUtilModelList)
         diffResult.dispatchUpdatesTo(this)
     }

    override fun getItemCount(): Int {
        return diffUtilModelList!!.size
    }


    inner class DiffUtilViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var diffUtilModel:EmployeeEntity?=null
        var currentPosition:Int = 0

        /*init{
            itemView.setOnClickListener{
                clickListener.onClick(diffUtilModel!!.id,currentPosition)
            }
        }*/

           fun setData(diffUtilModel: EmployeeEntity?,pos: Int){
              // itemView.template_item.text = "Registration Id:"+diffUtilModel!!.registrationId
               itemView.empid.text = "Emp ID:"+diffUtilModel!!.id
               itemView.empname.text =  "Name:"+diffUtilModel!!.empName
               var age:String = Integer.toString(diffUtilModel!!.empAge)
               itemView.empage.text =  age
               itemView.empplace.text = "Group:"+diffUtilModel!!.empCountry
               this.diffUtilModel = diffUtilModel
               this.currentPosition = pos
           }

    }
}
