package com.example.practicalproject.ui.main.persenter

import com.example.practicalproject.http.HttpUtils
import com.example.practicalproject.http.ResponseListenter
import com.example.practicalproject.http.UserApi
import com.example.practicalproject.mvp.model.BaseModel
import com.example.practicalproject.mvp.persenter.BasePersenter
import com.example.practicalproject.ui.main.model.MainModel
import com.example.practicalproject.ui.main.view.MainView

/**
 * @description
 * @author Created by SunYiDong on 2021/7/15 19:54.
 */
class MainPersenter : BasePersenter<MainView>() {
    fun getTest() {
        HttpUtils.sendHttp(HttpUtils.createApi(UserApi::class.java).getTest(),
            object : ResponseListenter<BaseModel<MainModel>> {
                override fun onSuccess(data: BaseModel<MainModel>) {
                if (data!=null){
                    getBaseView()!!.setData(data)
                }
                }

                override fun onFail(err: String) {
                    getBaseView()!!.setError(err)
                }

            })
    }
}