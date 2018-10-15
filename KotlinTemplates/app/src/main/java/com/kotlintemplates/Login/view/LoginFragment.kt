package com.kotlintemplates.Login.view


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.kotlintemplates.Login.viewmodel.LoginViewModel

import com.kotlintemplates.R
import kotlinx.android.synthetic.main.fragment_login.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class LoginFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var myView: View
    lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        loginViewModel = ViewModelProviders.of(activity!!).get(LoginViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        myView =  inflater.inflate(R.layout.fragment_login, container, false)
        initVars(myView)
         loginBtn.setOnClickListener{
            val email:String = login_email.text.toString()
            val password:String = login_password.text.toString()
            loginViewModel.validateCredentials(email,password).observe(this,object: Observer<String> {
                override fun onChanged(t: String?) {
                    Toast.makeText(activity, t, Toast.LENGTH_LONG).show()
                }
            })
        }
        return myView
    }

    lateinit var loginEmail: EditText
    lateinit var loginPassword: EditText
    lateinit var loginBtn: Button

    private fun initVars(view:View){
       /* loginEmail = view?.findViewById(R.id.login_email) as EditText
        loginPassword = view.findViewById(R.id.login_password) as EditText
        loginBtn = view.findViewById(R.id.login_btn) as Button
        loginBtn.setOnClickListener(this)*/
        loginEmail  =     view.findViewById<EditText>(R.id.login_email)
        loginPassword  =     view.findViewById<EditText>(R.id.login_password)
        loginBtn  =     view.findViewById<Button>(R.id.login_btn)


    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LoginFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                LoginFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}
