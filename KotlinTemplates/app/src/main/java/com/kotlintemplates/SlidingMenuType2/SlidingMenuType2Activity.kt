package com.kotlintemplates.SlidingMenuType2

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.kotlintemplates.GridList.View.GridListFragment
import com.kotlintemplates.Login.view.LoginFragment
import com.kotlintemplates.R
import com.kotlintemplates.RegistrationForm.View.EmployeeRegistrationFragment
import com.kotlintemplates.RoomDBList.View.RoomDBDiUtilListFragment
import com.kotlintemplates.RoomRetrofitList.View.RetrofitRoomKotlinFragment
import com.kotlintemplates.SimpleLazyList.Views.SimpleLazyListFragment
import kotlinx.android.synthetic.main.activity_sliding_menu_type2.*
import kotlinx.android.synthetic.main.app_bar_sliding_menu_type2.*

class SlidingMenuType2Activity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sliding_menu_type2)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.menu.findItem(R.id.nav_camera).isChecked = true
        val simpleLazyListFragment = SimpleLazyListFragment()
        supportFragmentManager.beginTransaction()
                .replace(R.id.frg_replace, simpleLazyListFragment)
                .commit()
        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.sliding_menu_type2, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_camera -> {
                // Handle the camera action
                nav_view.menu.findItem(R.id.nav_camera).isChecked = true
                val simpleLazyListFragment = SimpleLazyListFragment()
                supportFragmentManager.beginTransaction()
                        .replace(R.id.frg_replace, simpleLazyListFragment)
                        .commit()
            }
            R.id.nav_gallery -> {
                nav_view.menu.findItem(R.id.nav_gallery).isChecked = true
                supportFragmentManager.beginTransaction().replace(R.id.frg_replace, RoomDBDiUtilListFragment()).commit()

            }
            R.id.nav_slideshow -> {
                nav_view.menu.findItem(R.id.nav_slideshow).isChecked = true
                supportFragmentManager.beginTransaction().replace(R.id.frg_replace, GridListFragment()).commit()
            }
            R.id.nav_manage -> {
                nav_view.menu.findItem(R.id.nav_manage).isChecked = true
                supportFragmentManager.beginTransaction().replace(R.id.frg_replace, RetrofitRoomKotlinFragment()).commit()
            }
            R.id.nav_share -> {
                nav_view.menu.findItem(R.id.nav_share).isChecked = true
                supportFragmentManager.beginTransaction().replace(R.id.frg_replace, EmployeeRegistrationFragment()).commit()
            }
            R.id.nav_send -> {

                nav_view.menu.findItem(R.id.nav_send).isChecked = true
                supportFragmentManager.beginTransaction().replace(R.id.frg_replace, LoginFragment()).commit()
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
