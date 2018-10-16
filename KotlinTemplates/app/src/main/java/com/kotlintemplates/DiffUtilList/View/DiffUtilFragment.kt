package com.kotlintemplates.DiffUtilList.View


import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MultiAutoCompleteTextView
import com.google.firebase.database.*
import com.kotlintemplates.DiffUtilList.Model.DiffUtilModel
import com.kotlintemplates.Launcher.View.TemplateAdapter
import com.kotlintemplates.Launcher.interfaces.ClickListener

import com.kotlintemplates.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DiffUtilFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class DiffUtilFragment : Fragment(),ClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var dataBaseReference: DatabaseReference
    lateinit var myView: View
    var studentList: MutableList<DiffUtilModel>?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        initFireBase()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        myView =  inflater.inflate(R.layout.fragment_diff_util, container, false)
        initViews(myView)
        setAdapter()
        dataBaseReference.addListenerForSingleValueEvent(object :ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {
                studentList  = mutableListOf<DiffUtilModel>()
                for (studentSnapShot in p0!!.getChildren()) {
                    studentList!!.add(studentSnapShot.getValue(DiffUtilModel::class.java)!!)
                }
                if(studentList!!.size>0){
                    Log.d("DiffUtilragment","StudentList Size:::"+studentList!!.size)
                    diffUtilAdapter.setListInfo(studentList!!)
                    for (i in 0 until studentList!!.size) {
                        val diffUtilModel:DiffUtilModel = studentList!!.get(i)
                        Log.d("DiffUtilFragment",diffUtilModel.registrationId)
                    }
                }
            }
        });

        addList!!.setOnClickListener({
            populateData()
        });

        return myView
    }
    private fun populateData(){
        dataBaseReference.addListenerForSingleValueEvent(object :ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {
                studentList  = mutableListOf<DiffUtilModel>()
                for (studentSnapShot in p0!!.getChildren()) {
                    studentList!!.add(studentSnapShot.getValue(DiffUtilModel::class.java)!!)
                }
                if(studentList!!.size>0){
                    Log.d("DiffUtilragment","StudentList Size:::"+studentList!!.size)
                    diffUtilAdapter.updateStudentInfo(studentList!!)
                    for (i in 0 until studentList!!.size) {
                        val diffUtilModel:DiffUtilModel = studentList!!.get(i)
                        Log.d("DiffUtilFragment",diffUtilModel.registrationId)
                    }
                }
            }
        });
    }
    private var diffList: RecyclerView?=null;
    private var addList:FloatingActionButton?=null
    fun initViews(view:View){
        diffList = view.findViewById<RecyclerView>(R.id.diffutil_list)
        addList = view.findViewById<FloatingActionButton>(R.id.fabAddList)
    }
    fun initFireBase(){
        dataBaseReference = FirebaseDatabase.getInstance().getReference("students")

    }
    lateinit var diffUtilAdapter: DiffUtilAdapter

    private fun setAdapter(){
        //    launchList!!.adapter(TemplateAdapter(this,this))
        diffUtilAdapter = DiffUtilAdapter(activity!!.applicationContext,this)
        val layoutManager = LinearLayoutManager(activity)
     //   launchList!!.layoutManager = layoutManager
     //   launchList!!.adapter = templateAdapter
        //    launchList!!.adapter = TemplateAdapter(activity,this)
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
         * @return A new instance of fragment DiffUtilFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                DiffUtilFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}
