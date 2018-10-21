package com.kotlintemplates.GridList.View

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.kotlintemplates.Launcher.interfaces.ClickListener
import com.kotlintemplates.R
import com.kotlintemplates.SimpleLazyList.Model.SimpleLazyModel

import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.simple_lazy_list_item.view.*


class GridLazyListAdapter(val context: Context, val clickListener: ClickListener) : RecyclerView.Adapter<GridLazyListAdapter.SimpleLazyViewHolder>(){

    private var  simpleLazyInfoList:List<SimpleLazyModel>?=null


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): SimpleLazyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.grid_list_item,p0,false)
        return SimpleLazyViewHolder(view)
    }


    override fun onBindViewHolder(templateViewHolder: SimpleLazyViewHolder, pos: Int) {
        val templateInfo = simpleLazyInfoList!![pos]
        templateViewHolder.setData(templateInfo,pos)


    }

    public fun setListInfo(templateInfoList: List<SimpleLazyModel>){
        this.simpleLazyInfoList = templateInfoList
    }

    override fun getItemCount(): Int {
        return simpleLazyInfoList!!.size
    }


    inner class SimpleLazyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var templateModel: SimpleLazyModel?=null
        var currentPosition:Int = 0
        private val myImageView: ImageView = itemView.findViewById<ImageView>(R.id.thumbnail)

        init{

            itemView.setOnClickListener{
                clickListener.onClick(templateModel!!.title,currentPosition)
            }
        }

        fun setData(templateModel: SimpleLazyModel?, pos: Int){
            itemView.title.text = templateModel!!.title
          //  Picasso.with(itemView.context).load(templateModel!!.iconURL).into(itemView.thumbnail)
            Picasso.get()
                    .load(templateModel!!.iconURL)
                    .placeholder(R.drawable.dummy)
                    .into(itemView.thumbnail)
            this.templateModel = templateModel
            this.currentPosition = pos
        }

    }
}

