package com.kotlintemplates.DiffUtilList.View

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kotlintemplates.DiffUtilList.Model.DiffUtilModel
import com.kotlintemplates.Launcher.Model.TemplateModel
import com.kotlintemplates.Launcher.ViewModel.TemplateViewModel
import com.kotlintemplates.Launcher.interfaces.ClickListener
import com.kotlintemplates.R
import kotlinx.android.synthetic.main.template_list_item.view.*

class DiffUtilAdapter(val context: Context, val clickListener: ClickListener ) : RecyclerView.Adapter<DiffUtilAdapter.DiffUtilViewHolder>(){

   private var  diffUtilModelList:List<DiffUtilModel>?=null

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): DiffUtilViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.template_list_item,p0,false)
        return DiffUtilViewHolder(view)
    }


    override fun onBindViewHolder(DiffUtilViewHolder: DiffUtilViewHolder, pos: Int) {
       val templateInfo = diffUtilModelList!![pos]
        DiffUtilViewHolder.setData(templateInfo,pos)


    }

    public fun setListInfo(diffUtilModelList: List<DiffUtilModel>){
       this.diffUtilModelList = diffUtilModelList
    }

    override fun getItemCount(): Int {
        return diffUtilModelList!!.size
    }


    inner class DiffUtilViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var diffUtilModel:DiffUtilModel?=null
        var currentPosition:Int = 0

        init{
            itemView.setOnClickListener{
                clickListener.onClick(diffUtilModel!!.registrationId,currentPosition)
            }
        }

           fun setData(diffUtilModel: DiffUtilModel?,pos: Int){
               itemView.template_item.text = diffUtilModel!!.firstName
               this.diffUtilModel = diffUtilModel
               this.currentPosition = pos
           }

    }
}
