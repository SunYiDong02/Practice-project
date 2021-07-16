package com.example.practicalproject.http

/**
 * @description
 * @author Created by SunYiDong on 2021/7/16 14:02.
 */
interface ResponseListenter<T> {
    fun onSuccess(data:T)
    fun onFail(err:String)

}