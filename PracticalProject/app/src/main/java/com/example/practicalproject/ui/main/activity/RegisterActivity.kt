package com.example.practicalproject.ui.main.activity

import com.example.practicalproject.R
import com.example.practicalproject.base.BaseActivity
import com.example.practicalproject.ui.main.persenter.RegisterPersenter
import com.example.practicalproject.ui.main.view.RegisterView

class RegisterActivity : BaseActivity<RegisterView, RegisterPersenter>(), RegisterView {
    override fun getLayoutId(): Int = R.layout.activity_register

    override fun initData() {
    }

    override fun initView() {
    }



    override fun <T> setData(data: T) {

    }

    override fun setError(error: String) {
    }

    override fun createPersenter(): RegisterPersenter =RegisterPersenter()

}