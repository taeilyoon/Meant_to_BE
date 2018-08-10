package com.tqeil.meant_to_be.Views

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.tqeil.meant_to_be.Views.TABS.*


class MainPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
//
//    internal var featuredViewFragment: Fragment = FeaturedFragment()
//    internal var searchViewFragment: Fragment = SeachFragment()
//    internal var bookmarkViewFragment: Fragment = BookmarkFragment()
//    internal var settingViewFragment: Fragment = SettingFragment()
//    internal var buildViewFragment: Fragment = BuildFragment()

    var featuredFragment : Fragment = FeaturedFragment()
    var chatListFragment : Fragment = ChatListFragment()
    var missionFragment : Fragment = MissionFragment()
    var settingFragment : Fragment = SettingFragment()

    override fun getCount(): Int {
        return MainTabsType.values().size
    }


    override fun getItem(position: Int): Fragment? {
        val tabType = MainTabsType.MainTabsPositionMapping[position]



        when (tabType) {
            MainTabsType.Featured -> return featuredFragment
            MainTabsType.Chatroom -> return chatListFragment
            MainTabsType.Mission -> return missionFragment
            MainTabsType.Setting -> return settingFragment
            else -> return null
        }
    }

    companion object {
        private val TAG = "MainPagerAdapter"
    }


}
