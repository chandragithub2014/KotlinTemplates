package com.kotlintemplates.Launcher.View


import android.arch.lifecycle.Observer
import android.os.Bundle

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.kotlintemplates.DiffUtilList.View.DiffUtilActivity
import com.kotlintemplates.Launcher.Model.TemplateModel
import com.kotlintemplates.Launcher.ViewModel.TemplateViewModel
import com.kotlintemplates.Launcher.interfaces.ClickListener
import com.kotlintemplates.Login.view.LoginActivity


import com.kotlintemplates.R
import com.kotlintemplates.SimpleLazyList.Views.SimplyLazyListActivity

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TemplateListFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class TemplateListFragment : Fragment(),ClickListener {
   class MyTag {
       companion object {
           val TAG: String = TemplateListFragment::class.java.simpleName
       }
   }
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var myView:View
    private var launchList:RecyclerView?=null;
    lateinit var templateViewModel: TemplateViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

        initViewModel()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        myView  = inflater.inflate(R.layout.fragment_template_list, container, false)
        initiews(myView)
        setAdapter()

        templateViewModel.fetchTemplateList().observe(this,object: Observer<List<TemplateModel>>
        {
            override fun onChanged(t: List<TemplateModel>?) {
                   templateAdapter.setListInfo(t!!)
            }
        })

        return myView
    }


    private fun  initiews(view:View){
        launchList = view.findViewById<RecyclerView>(R.id.launcher_template)

    }

    private  fun initViewModel(){
        templateViewModel = ViewModelProviders.of(activity!!).get(TemplateViewModel::class.java)
    }

    lateinit var templateAdapter: TemplateAdapter

     private fun setAdapter(){
    //    launchList!!.adapter(TemplateAdapter(this,this))
        templateAdapter = TemplateAdapter(activity!!.applicationContext,this)
       val layoutManager = LinearLayoutManager(activity)
        launchList!!.layoutManager = layoutManager
        launchList!!.adapter = templateAdapter
    //    launchList!!.adapter = TemplateAdapter(activity,this)
    }
    override fun onClick(itemName: String, position: Int) {
        Log.d(MyTag.TAG,"Clicked Item::"+itemName+"Clicked Position:::"+position)
        Toast.makeText(activity,"Clicked Item::"+itemName+"Clicked Position:::"+position,Toast.LENGTH_SHORT).show()
        if(position == 0){
            var loginIntent : Intent = Intent(activity,LoginActivity::class.java)
            startActivity(loginIntent)
        }else if(position==1){
            var difUtilIntent : Intent = Intent(activity,DiffUtilActivity::class.java)
            startActivity(difUtilIntent)
        }else if(position==2) {
            var lazyListIntent: Intent = Intent(activity, SimplyLazyListActivity::class.java)
            startActivity(lazyListIntent)
        }
    }


    companion object {

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment TemplateListFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                TemplateListFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}