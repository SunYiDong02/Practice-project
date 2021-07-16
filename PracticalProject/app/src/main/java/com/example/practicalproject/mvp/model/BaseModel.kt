package com.example.practicalproject.mvp.model

/**
 * @description
 * @author Created by SunYiDong on 2021/7/15 19:36.
 */
data class BaseModel<T>(val code:Int,val message:String ,val date:T) {
}