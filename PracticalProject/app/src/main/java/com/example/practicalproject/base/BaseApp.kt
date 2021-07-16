package com.example.practicalproject.base

import android.app.Application
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger

/**
 * @description
 * @author Created by SunYiDong on 2021/7/16 11:21.
 */
class BaseApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Logger.addLogAdapter(AndroidLogAdapter())
    }
}