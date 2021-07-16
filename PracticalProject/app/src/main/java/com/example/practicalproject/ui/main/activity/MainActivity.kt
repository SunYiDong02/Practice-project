package com.example.practicalproject.ui.main.activity

import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.example.practicalproject.R
import com.example.practicalproject.base.BaseActivity
import com.example.practicalproject.ui.main.persenter.MainPersenter
import com.example.practicalproject.ui.main.view.MainView

class MainActivity : BaseActivity<MainView, MainPersenter>(),MainView {
    private var tv: TextView? = null

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun initData() {
    }

    override fun init() {
        tv = findViewById(R.id.tv_test)
        tv?.setOnClickListener { getPersenter()!!.getTest("test") }
    }

    override fun createPersenter() = MainPersenter()

    override fun <T> setData(data: T) {
        Log.e("test", "================>${data}")
        Toast.makeText(this,"test",Toast.LENGTH_LONG).show()
    }

    override fun setError(error: String) {
    }
}