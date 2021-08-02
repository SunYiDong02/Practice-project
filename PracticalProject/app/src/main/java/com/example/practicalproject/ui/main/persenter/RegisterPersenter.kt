package com.example.practicalproject.ui.main.persenter

import com.example.practicalproject.base.CodeModel
import com.example.practicalproject.http.HttpUtils
import com.example.practicalproject.http.ResponseListenter
import com.example.practicalproject.http.UserApi
import com.example.practicalproject.mvp.model.BaseModel
import com.example.practicalproject.mvp.persenter.BasePersenter
import com.example.practicalproject.ui.main.view.MainView
import com.example.practicalproject.ui.main.view.RegisterView

/**
 * @description
 * @author Created by SunYiDong on 2021/7/19 15:48.
 */
class RegisterPersenter : BasePersenter<RegisterView>() {
    fun getCode(phoneNumber: String) {
        HttpUtils.sendHttp(HttpUtils.createApi(UserApi::class.java).getCode(phoneNumber),
            object : ResponseListenter<BaseModel<CodeModel>> {
                override fun onSuccess(data: BaseModel<CodeModel>) {
                    if (data != null) {
                        if (data.code == 100) {
                            getBaseView()?.setData(data.data)
                        }
                    }
                }

                override fun onFail(err: String) {
                    getBaseView()?.setError(err)
                }
            })
    }
}