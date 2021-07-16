package com.example.practicalproject.http

import com.example.practicalproject.mvp.model.BaseModel
import com.example.practicalproject.ui.main.model.MainModel
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * @description
 * @author Created by SunYiDong on 2021/7/16 16:45.
 */
interface UserApi {
    @GET("journalismApi")
    fun getTest(): Observable<BaseModel<MainModel>>
}