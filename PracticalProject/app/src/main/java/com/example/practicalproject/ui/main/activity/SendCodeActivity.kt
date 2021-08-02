package com.example.practicalproject.ui.main.activity

import android.text.TextUtils
import com.example.practicalproject.R
import com.example.practicalproject.base.BaseActivity
import com.example.practicalproject.base.Constants
import com.example.practicalproject.base.Constants.COUNT_TIME
import com.example.practicalproject.base.Constants.COUNT_TIME_INTERVAL
import com.example.practicalproject.ui.main.persenter.RegisterPersenter
import com.example.practicalproject.ui.main.view.RegisterView
import com.example.practicalproject.view.AuthCodeTimer
import com.example.practicalproject.view.CountDownListener
import kotlinx.android.synthetic.main.activity_send_code.*

class SendCodeActivity : BaseActivity<RegisterView, RegisterPersenter>(), RegisterView,
    CountDownListener {

    private var mAuthCodeTimer: AuthCodeTimer? = null
    private var phone: String? = null
    private var code: String? = null
    private var actionTyp = 0

    override fun getLayoutId(): Int = R.layout.activity_send_code

    override fun initData() {

    }

    override fun initView() {
//        if (intent!=null){
//            phone=intent.getStringExtra(Constants.MOBLIE)
//        }
        btn_back.setOnClickListener { finish() }
        if (intent !=null){
            phone=intent.getStringExtra(Constants.MOBLIE)
            actionTyp=intent.getIntExtra(Constants.USER_ACTION,0)
        }
        mAuthCodeTimer = AuthCodeTimer(COUNT_TIME, COUNT_TIME_INTERVAL, this)
        mAuthCodeTimer?.start()
    }

    override fun createPersenter(): RegisterPersenter = RegisterPersenter()

    override fun <T> setData(data: T) {
        TODO("Not yet implemented")
    }

    override fun setError(error: String) {
        TODO("Not yet implemented")
    }

    override fun countDown(time: Long) {
        val s: String = ("重新获取(${time / 1000})秒")
        tv_send_code.text = s
        tv_send_code.isEnabled = false
    }

    override fun isOverTime(isOverTime: Boolean) {
        tv_send_code.text = "重新获取"
        tv_send_code.isEnabled = true
    }

}


