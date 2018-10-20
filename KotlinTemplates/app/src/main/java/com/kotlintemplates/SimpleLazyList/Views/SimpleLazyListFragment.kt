package com.kotlintemplates.SimpleLazyList.Views


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.os.RecoverySystem
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kotlintemplates.Launcher.Model.TemplateModel
import com.kotlintemplates.Launcher.View.TemplateAdapter
import com.kotlintemplates.Launcher.ViewModel.TemplateViewModel
import com.kotlintemplates.Launcher.interfaces.ClickListener

import com.kotlintemplates.R
import com.kotlintemplates.SimpleLazyList.Model.SimpleLazyModel
import com.kotlintemplates.SimpleLazyList.ViewModel.SimpleLazyListViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SimpleLazyListFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
//http://www.technotalkative.com/lazy-productive-android-developer-part-5-image-loading-library/
class SimpleLazyListFragment : Fragment(), ClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var myView: View
    lateinit var simpleLazyListViewModel: SimpleLazyListViewModel

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
        myView =  inflater.inflate(R.layout.fragment_simple_lazy_list, container, false)
        initViews(myView)
        setAdapter()
        simpleLazyListViewModel.getSimpleListData().observe(this,object: Observer<List<SimpleLazyModel>>
        {
            override fun onChanged(t: List<SimpleLazyModel>?) {
                simpleLazyListAdapter.setListInfo(t!!)
            }
        })
        return  myView
    }

     lateinit var lazyRecyclerView: RecyclerView
     fun initViews(view:View){
         lazyRecyclerView = view.findViewById<RecyclerView>(R.id.simple_lazy_list)
     }
    private  fun initViewModel(){
        simpleLazyListViewModel = ViewModelProviders.of(activity!!).get(SimpleLazyListViewModel::class.java)
    }
    lateinit var simpleLazyListAdapter: SimpleLazyListAdapter

    fun setAdapter(){
        simpleLazyListAdapter = SimpleLazyListAdapter(activity!!.applicationContext,this)
        val layoutManager = LinearLayoutManager(activity)
        lazyRecyclerView!!.layoutManager = layoutManager
        lazyRecyclerView!!.adapter = simpleLazyListAdapter
    }


    override fun onClick(itemName: String, position: Int) {

    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SimpleLazyListFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                SimpleLazyListFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}
