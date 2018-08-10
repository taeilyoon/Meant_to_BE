package com.tqeil.meant_to_be.Views

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.PorterDuff
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.support.design.widget.CollapsingToolbarLayout
import android.support.design.widget.CoordinatorLayout
import android.support.design.widget.Snackbar
import android.support.design.widget.TabLayout
import android.support.v4.content.ContextCompat
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.tqeil.meant_to_be.R
import devlight.io.library.ntb.NavigationTabBar
import kotlinx.android.synthetic.main.activity_main_tab.*
import me.majiajie.pagerbottomtabstrip.MaterialMode
import me.majiajie.pagerbottomtabstrip.NavigationController
import me.majiajie.pagerbottomtabstrip.PageNavigationView
import me.majiajie.pagerbottomtabstrip.listener.OnTabItemSelectedListener
import java.util.*

class MainTabActivity : AppCompatActivity() {


    internal var testColors = intArrayOf(-0xbaa59c, -0xff8695, -0x86aab8, -0xa4b6b9, -0xa8400)
//    int[] testColors = {0xFF009688, 0xFF009688, 0xFF009688, 0xFF009688, 0xFF009688};

    internal lateinit var mNavigationController: NavigationController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        instance = this

        setTheme(R.style.AppTheme)
        setContentView(R.layout.activity_main_tab)
        InitTAB()

    }
    fun InitTAB(){

        val pageBottomTabLayout = findViewById(R.id.tab) as PageNavigationView

        mNavigationController = pageBottomTabLayout.material().addItem(R.drawable.add, "Movies & TV", testColors[0]).addItem(R.drawable.add, "Music",
                testColors[1]).addItem(R.drawable.add, "Books", testColors[2]).addItem(R.drawable.add, "Newsstand", testColors[3]).setDefaultColor(-0x76000001)//未选中状态的颜色
                .setMode(MaterialMode.CHANGE_BACKGROUND_COLOR or MaterialMode.HIDE_TEXT)//这里可以设置样式模式，总共可以组合出4种效果
                .build()

        val viewPager = findViewById(R.id.viewPager) as ViewPager
        viewPager.adapter = MainPagerAdapter(supportFragmentManager)

        mNavigationController.setupWithViewPager(viewPager)

        mNavigationController.addTabItemSelectedListener(object : OnTabItemSelectedListener {
            override fun onSelected(index: Int, old: Int) {
                Log.i("asd", "selected: $index old: $old")
            }

            override fun onRepeat(index: Int) {
                Log.i("asd", "onRepeat selected: $index")
            }
        })

    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

    }

    override fun onBackPressed() {
        AskIfQuitApp()
    }
    fun AskIfQuitApp() {
        //            new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
        //                    .setTitleText(getString(R.string.quit_app_title))
        //                    .setContentText(getString(R.string.quit_app_content))
        //                    .setCancelText(getString(R.string.quit_app_cancel))
        //                    .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
        //                        @Override
        //                        public void onClick(SweetAlertDialog sDialog) {
        //                            sDialog.cancel();
        //                        }
        //                    })
        //
        //                    .setConfirmText(getString(R.string.quit_app_confirm))
        //                    .setConfirmClickListener (new SweetAlertDialog.OnSweetClickListener() {
        //                        @Override
        //                        public void onClick(SweetAlertDialog sDialog) {
        //                            sDialog.dismissWithAnimation();
        //                            finish();
        //                        }
        //                    }).show();
    }

    companion object {
        var instance: MainTabActivity? = null
    }


}
