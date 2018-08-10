package com.tqeil.meant_to_be.Views

import java.util.HashMap

enum class MainTabsType  constructor(value: Int) {
    Featured(0), Chatroom(1), Mission(2), Setting(3);

    var value: Int = 0
        internal set

    init {
        this.value = value
    }

    companion object {


        var MainTabsPositionMapping: Map<Int, MainTabsType> = object : HashMap<Int, MainTabsType>() {
            init {
                put(0, Featured)
                put(1, Chatroom)
                put(2, Mission)
                put(3, Setting)
            }
        }
    }
}
