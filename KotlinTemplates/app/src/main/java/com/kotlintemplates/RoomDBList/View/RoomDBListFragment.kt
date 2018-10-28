package com.kotlintemplates.RoomDBList.View


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.database.DatabaseReference
import com.kotlintemplates.DiffUtilList.Model.DiffUtilModel
import com.kotlintemplates.DiffUtilList.View.DiffUtilAdapter
import com.kotlintemplates.DiffUtilList.ViewModel.DiffUtilViewModel
import com.kotlintemplates.Launcher.interfaces.ClickListener

import com.kotlintemplates.R
import com.kotlintemplates.RoomDBList.Model.EmployeeEntity
import com.kotlintemplates.RoomDBList.ViewModel.RoomDBViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RoomDBListFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class RoomDBListFragment : Fragment(),ClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    lateinit var myView: View
    var empList: List<EmployeeEntity>?=null
    lateinit var roomDBViewModel: RoomDBViewModel

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
        myView =  inflater.inflate(R.layout.fragment_room_dblist, container, false)
        initViews(myView)
        setAdapter()
        setEmptyList()
        updateAdapterInfoFromViewModel()
        return myView
    }
    private  fun initViewModel(){
        roomDBViewModel = ViewModelProviders.of(activity!!).get(RoomDBViewModel::class.java)
    }

    private var dbList: RecyclerView?=null;
    private var addList: FloatingActionButton?=null
    fun initViews(view:View){
        dbList = view.findViewById<RecyclerView>(R.id.db_list)

    }

    lateinit var roomDBAdapter: RoomDBAdapter
    fun setAdapter(){
        roomDBAdapter = RoomDBAdapter(activity!!.applicationContext,this)
        val layoutManager = LinearLayoutManager(activity)
        dbList!!.layoutManager = layoutManager
        dbList!!.adapter = roomDBAdapter

    }

 fun setEmptyList(){
     val mutableList : MutableList<EmployeeEntity> = ArrayList()
     roomDBAdapter.setListInfo(mutableList)

 }

      fun updateAdapterInfoFromViewModel(){
          roomDBViewModel.getAllEmps().observe(this,object: Observer<List<EmployeeEntity>> {
              override fun onChanged(t: List<EmployeeEntity>?) {
                  roomDBAdapter.updateStudentInfo(t!!.toMutableList())
              }
          })
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
         * @return A new instance of fragment RoomDBListFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                RoomDBListFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}
