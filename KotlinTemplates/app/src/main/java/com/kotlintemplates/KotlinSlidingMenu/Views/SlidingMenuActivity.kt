package com.kotlintemplates.KotlinSlidingMenu.Views

import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import com.kotlintemplates.GridList.View.GridListFragment
import com.kotlintemplates.KotlinTabs.Views.TabActivity
import com.kotlintemplates.Login.view.LoginFragment
import com.kotlintemplates.R
import com.kotlintemplates.RegistrationForm.View.EmployeeRegistrationFragment
import com.kotlintemplates.RoomDBList.View.RoomDBDiUtilListFragment
import com.kotlintemplates.RoomRetrofitList.View.RetrofitRoomKotlinFragment
import com.kotlintemplates.SimpleLazyList.Views.SimpleLazyListFragment

class SlidingMenuActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private val SELECTED_ITEM_ID = "selected_item_id"
    private val FIRST_TIME = "first_time"
    lateinit var mToolbar: Toolbar
    lateinit var navigationViewDrawer: NavigationView
    lateinit var mDrawerLayout: DrawerLayout
    lateinit var mActionBarDrawerToggle: ActionBarDrawerToggle
    private var mSelectedId: Int = 0
    private var mUserSawDrawer = false
    lateinit var popUpMenu: Menu
    private var appCompatActivity: AppCompatActivity? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sliding_menu)
        mToolbar =  findViewById<Toolbar>(R.id.app_toolbar)as Toolbar
        setSupportActionBar(mToolbar)
        val mInflater = LayoutInflater.from(applicationContext)
        val mCustomView = mInflater.inflate(R.layout.toolbar_custom_view, null)
        mToolbar.addView(mCustomView)
       // saveActivityStateInGlobal()
        navigationViewDrawer = findViewById<NavigationView>(R.id.main_nav_view_drawer) as NavigationView
        mDrawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout) as DrawerLayout
        mActionBarDrawerToggle = ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.drawer_open, R.string.drawer_close)
        mDrawerLayout.addDrawerListener(mActionBarDrawerToggle)
        mActionBarDrawerToggle.syncState()

        navigationViewDrawer.setNavigationItemSelectedListener(this)
        if (!didUserSeeDrawer()) {
            showDrawer();
            markDrawerSeen();
        } else {
            hideDrawer();
        }
        mSelectedId = savedInstanceState?.getInt(SELECTED_ITEM_ID) ?: R.id.basic_login_navigation_item
        navigate(mSelectedId)
    }


    private fun didUserSeeDrawer(): Boolean {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        mUserSawDrawer = sharedPreferences.getBoolean(FIRST_TIME, false)
        return mUserSawDrawer
    }

    private fun markDrawerSeen() {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        mUserSawDrawer = true
        sharedPreferences.edit().putBoolean(FIRST_TIME, mUserSawDrawer).apply()
    }

    private fun showDrawer() {
        mDrawerLayout!!.openDrawer(GravityCompat.START)
    }

    private fun hideDrawer() {
        mDrawerLayout!!.closeDrawer(GravityCompat.START)
    }




    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        menuItem.setChecked(true)
        mSelectedId = menuItem.getItemId()

        navigate(mSelectedId)
        return true
    }

    private fun navigate(mSelectedId:Int) {
        if(mSelectedId == R.id.basic_login_navigation_item){
            mDrawerLayout.closeDrawer(GravityCompat.START)
            val basicLoginFrag = LoginFragment()
            supportFragmentManager.beginTransaction()
                    .replace(R.id.frag_parentLayout, basicLoginFrag)
                    .commit()

        }else if(mSelectedId == R.id.navigation_item_2){
            mDrawerLayout.closeDrawer(GravityCompat.START)
            val registrationFragment = EmployeeRegistrationFragment()
            supportFragmentManager.beginTransaction()
                    .replace(R.id.frag_parentLayout, registrationFragment)
                    .commit()

        }else if(mSelectedId == R.id.navigation_item_16){
            mDrawerLayout.closeDrawer(GravityCompat.START)
            val simpleLazyListFragment = SimpleLazyListFragment()
            supportFragmentManager.beginTransaction()
                    .replace(R.id.frag_parentLayout, simpleLazyListFragment)
                    .commit()



        }else if(mSelectedId == R.id.navigation_item_19){
            mDrawerLayout.closeDrawer(GravityCompat.START)
            val diffList = RoomDBDiUtilListFragment()
            supportFragmentManager.beginTransaction()
                    .replace(R.id.frag_parentLayout, diffList)
                    .commit()

        }else if(mSelectedId == R.id.navigation_item_18){
            mDrawerLayout.closeDrawer(GravityCompat.START)
            val gridList = GridListFragment()
            supportFragmentManager.beginTransaction()
                    .replace(R.id.frag_parentLayout, gridList)
                    .commit()

        }else if(mSelectedId == R.id.navigation_item_tab){
            mDrawerLayout.closeDrawer(GravityCompat.START)
            val tabIntent:Intent = Intent(this,TabActivity::class.java)
            startActivity(tabIntent)
        }else if(mSelectedId == R.id.navigation_item_retro_list){
            mDrawerLayout.closeDrawer(GravityCompat.START)
            val retroList = RetrofitRoomKotlinFragment()
            supportFragmentManager.beginTransaction()
                    .replace(R.id.frag_parentLayout, retroList)
                    .commit()

        }



    }
}
