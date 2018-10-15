package com.kotlintemplates.DiffUtilList.View


import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MultiAutoCompleteTextView
import com.google.firebase.database.*
import com.kotlintemplates.DiffUtilList.Model.DiffUtilModel

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
class DiffUtilFragment : Fragment() {
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
        dataBaseReference.addListenerForSingleValueEvent(object :ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onDataChange(p0: DataSnapshot) {
                studentList  = mutableListOf<DiffUtilModel>()
                for (studentSnapShot in p0!!.getChildren()) {
                    studentList!!.add(studentSnapShot.getValue(DiffUtilModel::class.java)!!)
                }
                if(studentList!!.size>0){
                    Log.d("DiffUtilragment","StudentList Size:::"+studentList!!.size)
                    for (i in 0 until studentList!!.size) {
                        val diffUtilModel:DiffUtilModel = studentList!!.get(i)
                        Log.d("DiffUtilFragment",diffUtilModel.registrationId)
                    }
                }
            }
        });

        return myView
    }

    fun initFireBase(){
        dataBaseReference = FirebaseDatabase.getInstance().getReference("students")

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
