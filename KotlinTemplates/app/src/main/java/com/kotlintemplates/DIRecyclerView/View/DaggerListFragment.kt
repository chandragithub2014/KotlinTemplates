package com.kotlintemplates.DIRecyclerView.View


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.kotlintemplates.DIRecyclerView.RetroDIApplication
import com.kotlintemplates.DIRecyclerView.ViewModel.RetroDIViewModel

import com.kotlintemplates.R
import com.kotlintemplates.RoomRetrofitList.Repository.ResultModel
import com.kotlintemplates.RoomRetrofitList.View.PostsAdapter
import retrofit2.Retrofit
import javax.inject.Inject




// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DaggerListFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class DaggerListFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    @Inject
    lateinit var retrofit: Retrofit
    lateinit var myView: View
    lateinit var retroDIViewModel: RetroDIViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity!!.application as RetroDIApplication).retroComponent.inject(this)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        myView =  inflater.inflate(R.layout.fragment_dagger_list, container, false)
        retroDIViewModel = ViewModelProviders.of(this).get(RetroDIViewModel::class.java)
        initViews(myView)
        setAdapter()
        retroDIViewModel.fetchPostsFromWebSevice(retrofit).observe(this,object : Observer<List<ResultModel>> {

            override fun onChanged(t: List<ResultModel>?) {
                userPostAdapter.setListItems(t)

            }
        })
        return myView
    }

    lateinit var lazyRecyclerView: RecyclerView
    fun initViews(view:View){
        lazyRecyclerView = view.findViewById<RecyclerView>(R.id.simple_dagger_list)
    }

    lateinit var userPostAdapter: PostsAdapter

    private  fun setAdapter(){

        userPostAdapter = PostsAdapter()
        lazyRecyclerView.layoutManager = LinearLayoutManager(activity, LinearLayout.VERTICAL, false)
        lazyRecyclerView.adapter = userPostAdapter

    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DaggerListFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                DaggerListFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}
