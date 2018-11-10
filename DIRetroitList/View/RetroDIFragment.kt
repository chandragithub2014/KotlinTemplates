package com.kotlintemplates.DIRetroitList.View


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kotlintemplates.DIRetroitList.Model.RetroModel
import com.kotlintemplates.DIRetroitList.Repository.APIService
import com.kotlintemplates.DIRetroitList.ViewModel.RetroDIListViewModel
import com.kotlintemplates.KotlinTemplateApplication

import com.kotlintemplates.R
import com.kotlintemplates.RoomRetrofitList.Repository.ResultModel
import com.kotlintemplates.RoomRetrofitList.ViewModel.PostListViewModel
import dagger.android.AndroidInjection
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RetroDIFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class RetroDIFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var retroDIListViewModel: RetroDIListViewModel
    lateinit var retroFitDIView: View
    @Inject
    lateinit var apiService: APIService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        retroDIListViewModel = ViewModelProviders.of(activity!!).get(RetroDIListViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        retroFitDIView =  inflater.inflate(R.layout.fragment_retro_di, container, false)

        return retroFitDIView
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
  //      AndroidSupportInjection.inject(this)
        AndroidInjection.inject(activity)
        KotlinTemplateApplication.instance.fetchRetroComponent().inject(this@RetroDIFragment)

        retroDIListViewModel.fetchPostsFromWebSevice(apiService).observe(this,object : Observer<List<RetroModel>>{
            override fun onChanged(t: List<RetroModel>?) {
                for (i in t!!.indices)
                    println(t[i].id)
            }

        })
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RetroDIFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                RetroDIFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}
