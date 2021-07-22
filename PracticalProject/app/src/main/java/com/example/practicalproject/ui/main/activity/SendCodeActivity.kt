package com.example.practicalproject.ui.main.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practicalproject.R
import com.example.practicalproject.base.BaseActivity
import com.example.practicalproject.ui.main.persenter.RegisterPersenter
import com.example.practicalproject.ui.main.view.RegisterView
import com.example.practicalproject.view.AuthCodeTimer
import com.example.practicalproject.view.CountDownListener
import kotlinx.android.synthetic.main.activity_send_code.*
import kotlinx.android.synthetic.main.my_checkbox.view.*

class SendCodeActivity : BaseActivity<RegisterView, RegisterPersenter>(), RegisterView,
    CountDownListener {

    private var mAuthCodeTimer: AuthCodeTimer? = null

    override fun getLayoutId(): Int = R.layout.activity_send_code

    override fun initData() {}

    override fun initView() {
        mAuthCodeTimer = AuthCodeTimer(10000, 1000, this)
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
        tv_obtain.text = s
        tv_obtain.isEnabled = false
    }

    override fun isOverTime(isOverTime: Boolean) {
        tv_obtain.text = "重新获取"
        tv_obtain.isEnabled = true
    }

}