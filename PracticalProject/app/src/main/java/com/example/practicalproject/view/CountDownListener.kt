package com.example.practicalproject.view

/**
 * @description
 * @author Created by SunYiDong on 2021/7/22 10:10.
 */
interface CountDownListener {
    fun countDown(time:Long)
    fun isOverTime(isOverTime:Boolean)
}