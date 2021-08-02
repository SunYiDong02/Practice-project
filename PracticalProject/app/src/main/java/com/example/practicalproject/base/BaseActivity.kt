package com.example.practicalproject.base

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.example.practicalproject.R
import com.example.practicalproject.base.Constants.COMMON_BAR
import com.example.practicalproject.http.HttpUtils
import com.example.practicalproject.mvp.persenter.BasePersenter
import com.example.practicalproject.mvp.view.BaseView
import com.example.practicalproject.utils.StatusBarUtils

abstract class BaseActivity<V, P : BasePersenter<V>> : AppCompatActivity(), BaseView {
    private var mPersenter: P? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        StatusBarUtils.setStatusBar(this,COMMON_BAR,R.color.white)
        if (mPersenter == null) {
            mPersenter = createPersenter() as P
        }
        mPersenter!!.bindView(this as V)
        initView()
        initData()
    }
    protected abstract fun getLayoutId():Int
    protected abstract fun initData()
    protected abstract fun initView()
    protected abstract fun createPersenter():P
    fun getPersenter() = mPersenter
    override fun onDestroy() {
        super.onDestroy()
        mPersenter!!.unBindView()
    }

    fun startActivity(clz:Class<*>){
        startActivity(Intent(this,clz))
    }

    fun setLightStatusBar(){
            StatusBarUtils.setStatusBar(this, View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR,R.color.theme)
    }
    fun setLightNavigationBar(){
        StatusBarUtils.setStatusBar(this, View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR,R.color.theme)
    }

}