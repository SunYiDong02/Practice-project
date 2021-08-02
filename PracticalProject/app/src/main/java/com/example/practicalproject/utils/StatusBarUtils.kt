package com.example.practicalproject.utils

import android.app.Activity
import android.graphics.Color
import android.os.Build
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.core.content.ContextCompat
import com.example.practicalproject.base.Constants.HOME_BAR

/**
 * @description
 * @author Created by SunYiDong on 2021/7/19 15:15.
 */
object StatusBarUtils {

    private var flags: Int = View.SYSTEM_UI_FLAG_LAYOUT_STABLE

    fun setStatusBar(activity: Activity, statusType: Int, colorIds: Int) {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            val mWindow: Window = activity.window
            mWindow.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            mWindow.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            mWindow.statusBarColor= Color.TRANSPARENT
            if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
                flags=View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            }
            activity.window.decorView.systemUiVisibility= flags
            setUiVisibility(mWindow,statusType)
            setColor(mWindow,ContextCompat.getColor(activity,colorIds))
        }
    }

    private fun setUiVisibility(mWindow: Window, statusType: Int) {
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            mWindow.decorView.systemUiVisibility=statusType
        }
    }
    private fun setColor(mWindow: Window,color: Int){
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            mWindow.statusBarColor=color
        }
    }
}