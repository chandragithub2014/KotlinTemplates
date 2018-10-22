package com.kotlintemplates.KotlinTabs.Views

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.ViewPager
import android.widget.TableLayout
import com.kotlintemplates.R


class TabActivity : AppCompatActivity() {

    lateinit var viewPager:ViewPager
    lateinit var tabLayout:TabLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab)
        initViews()
        setStatePageAdapter()
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
                val fm = supportFragmentManager
                val ft = fm.beginTransaction()
                val count = fm.backStackEntryCount
                if (count >= 1) {
                    supportFragmentManager.popBackStack()
                }
                ft.commit()
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                // setAdapter();


            }

            override fun onTabReselected(tab: TabLayout.Tab) {

                //   viewPager.notifyAll();
            }
        })
    }

    private fun  initViews(){
        viewPager = findViewById<ViewPager>(R.id.pager)
        tabLayout = findViewById<TabLayout>(R.id.tabs)
    }

        private fun setStatePageAdapter(){
           val myViewPageStateAdapter:MyViewPageStateAdapter = MyViewPageStateAdapter(supportFragmentManager)
            myViewPageStateAdapter.addFragment(KotlinTab1ContainerFragment(),"LazyList")
            myViewPageStateAdapter.addFragment(KotlinTab2ContainerFragment(),"MVVMRetroList")
            myViewPageStateAdapter.addFragment(KotlinTab3ContainerFragment(),"MVVMGridList")
            myViewPageStateAdapter.addFragment(KotlinTab4ContainerFragment(),"MVVMDiffList")
            viewPager.adapter=myViewPageStateAdapter
            tabLayout.setupWithViewPager(viewPager,true)

        }
    class MyViewPageStateAdapter(fm:FragmentManager):FragmentStatePagerAdapter(fm){
        val fragmentList:MutableList<Fragment> = ArrayList<Fragment>()
        val fragmentTitleList:MutableList<String> = ArrayList<String>()

        override fun getItem(position: Int): Fragment {
            return fragmentList.get(position)
        }

        override fun getCount(): Int {
            return fragmentList.size
         }

        override fun getPageTitle(position: Int): CharSequence? {
            return fragmentTitleList.get(position)
        }

        fun addFragment(fragment:Fragment,title:String){
            fragmentList.add(fragment)
            fragmentTitleList.add(title)

        }
    }
}

