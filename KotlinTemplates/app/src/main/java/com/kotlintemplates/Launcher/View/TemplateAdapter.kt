package com.kotlintemplates.Launcher.View

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kotlintemplates.Launcher.Model.TemplateModel
import com.kotlintemplates.Launcher.ViewModel.TemplateViewModel
import com.kotlintemplates.Launcher.interfaces.ClickListener
import com.kotlintemplates.R
import kotlinx.android.synthetic.main.template_list_item.view.*

class TemplateAdapter(val context: Context,val clickListener: ClickListener ) : RecyclerView.Adapter<TemplateAdapter.TemplateViewHolder>(){

   private var  templateInfoList:List<TemplateModel>?=null

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): TemplateViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.template_list_item,p0,false)
        return TemplateViewHolder(view)
    }


    override fun onBindViewHolder(templateViewHolder: TemplateViewHolder, pos: Int) {
       val templateInfo = templateInfoList!![pos]
        templateViewHolder.setData(templateInfo,pos)


    }

    public fun setListInfo(templateInfoList: List<TemplateModel>){
       this.templateInfoList = templateInfoList
    }

    override fun getItemCount(): Int {
        return templateInfoList!!.size
    }


    inner class TemplateViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var templateModel:TemplateModel?=null
        var currentPosition:Int = 0

        init{
            itemView.setOnClickListener{
                clickListener.onClick(templateModel!!.templateName,currentPosition)
            }
        }

           fun setData(templateModel: TemplateModel?,pos: Int){
               itemView.template_item.text = templateModel!!.templateName
               this.templateModel = templateModel
               this.currentPosition = pos
           }

    }
}
