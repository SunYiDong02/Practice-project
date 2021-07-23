package com.example.practicalproject.http

import com.example.practicalproject.base.CodeModel
import com.example.practicalproject.mvp.model.BaseModel
import com.example.practicalproject.ui.main.model.MainModel
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * @description
 * @author Created by SunYiDong on 2021/7/16 16:45.
 */
interface UserApi {
    @GET("journalismApi")
    fun getTest(): Observable<BaseModel<MainModel>>

    @FormUrlEncoded
    @POST("user/news/sendCode")
    fun getCode(@Field("phoneNumber")phone:String):Observable<BaseModel<CodeModel>>
}