package com.kotlintemplates.RoomDBList.View


import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

import com.kotlintemplates.R
import com.kotlintemplates.RoomDBList.Model.EmployeeEntity
import com.kotlintemplates.RoomDBList.ViewModel.RoomDBViewModel
import com.kotlintemplates.RoomRetrofitList.Repository.ResultModel
import com.kotlintemplates.RoomRetrofitList.ViewModel.PostListViewModel
import com.kotlintemplates.SimpleLazyList.Views.SimpleLazyListFragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [NewEmployeeFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class NewEmployeeFragment : Fragment(),View.OnClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var newEmployeeView: View
    lateinit var roomDbViewModel: RoomDBViewModel
    private var mContainterId:Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        roomDbViewModel = ViewModelProviders.of(activity!!).get(RoomDBViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        newEmployeeView =  inflater.inflate(R.layout.fragment_new_employee, container, false)
        mContainterId  = container!!.id
        initViews(newEmployeeView)
        return newEmployeeView
    }
    lateinit var employeeName:EditText
    lateinit var empAge:EditText
    lateinit var empPlace:EditText
    lateinit var saveInfo:Button
    lateinit var cancelInfo:Button

    fun initViews(myView:View){
        employeeName  = myView.findViewById<EditText>(R.id.empName)as EditText
        empAge = myView.findViewById<EditText>(R.id.empAge)as EditText
        empPlace = myView.findViewById<EditText>(R.id.empCnty)as EditText
        saveInfo = myView.findViewById<EditText>(R.id.save_info)as Button
        cancelInfo = myView.findViewById<EditText>(R.id.cancel_info)as Button
        saveInfo.setOnClickListener(this)
        cancelInfo.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
     if(p0==saveInfo) {
         if (collectInputInfo() != null) {
             roomDbViewModel.insertEmpInfo(collectInputInfo())
         }
     }else if(p0==cancelInfo){
         empAge.setText("")
         empPlace.setText("")
         employeeName.setText("")
     }

       /* Log.d(TAG,"EmpList:::"+roomDbViewModel.getAllEmps())
         var empList :List<EmployeeEntity> = roomDbViewModel.getAllEmps().value!!
         if(empList.size>0){
            for(i in empList.indices){
                Log.d(TAG,"EmpId::"+empList[i].id+"\n"
                                +"EmpName:::"+empList[i].empName+"\n"
                        +"EmpAge:::"+empList[i].empAge+"\n"
                        +"EmpCountry:::"+empList[i].empCountry+"\n")
            }
         }*/
        launchEmpList()
        roomDbViewModel.getAllEmps().observe(this,object:Observer<List<EmployeeEntity>>{
            override fun onChanged(t: List<EmployeeEntity>?) {
                if(t!=null && t.size>0){
                    for (i in t.indices) {
                       Log.d(TAG,"Emp Info:::"+t[i].empName+"Id::="+t[i].id)
                    }
                }
            }
        })
    }


    fun collectInputInfo():EmployeeEntity{
        var employeeEntity:EmployeeEntity?=null
        if(!TextUtils.isEmpty(employeeName.text.toString()) &&
                !TextUtils.isEmpty(empAge.text.toString()) &&
                !TextUtils.isEmpty(empPlace.text.toString())){
            employeeEntity = EmployeeEntity()
            employeeEntity.empName = employeeName.text.toString()
            employeeEntity.empAge = Integer.parseInt(empAge.text.toString())
            employeeEntity.empCountry = empPlace.text.toString()

        }else{
            Toast.makeText(activity,"Please Fill all the Info",Toast.LENGTH_LONG).show()
        }

        return employeeEntity!!
    }

    fun launchEmpList(){
        empAge.setText("")
        empPlace.setText("")
        employeeName.setText("")
        activity!!.supportFragmentManager.beginTransaction().replace(mContainterId, RoomDBListFragment()).addToBackStack(null).commit()
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment NewEmployeeFragment.
         */
        // TODO: Rename and change types and number of parameters
        val TAG:String = "NewEmpFrag"
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                NewEmployeeFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}
