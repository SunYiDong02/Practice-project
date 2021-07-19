package com.example.practicalproject.utils

import android.app.Activity
import android.os.Build
import android.view.View
import androidx.core.content.ContextCompat
import com.example.practicalproject.base.Constants.HOME_BAR

/**
 * @description
 * @author Created by SunYiDong on 2021/7/19 15:15.
 */
object StatusBarUtils {
    fun setStatusBar(activity: Activity, barType: Int, colorIds: Int) {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            if (barType == HOME_BAR) {
                activity.window.decorView.systemUiVisibility =
                    View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
            } else {
                activity.window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            }
            activity.window.statusBarColor=ContextCompat.getColor(activity,colorIds)
        }
    }
}