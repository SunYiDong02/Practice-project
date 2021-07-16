package com.example.practicalproject.mvp.view

/**
 * @description
 * @author Created by SunYiDong on 2021/7/15 19:35.
 */
interface BaseView {
    fun <T> setData(data: T)
    fun setError(error: String)
}