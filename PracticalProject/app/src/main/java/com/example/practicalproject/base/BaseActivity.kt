package com.example.practicalproject.base

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.example.practicalproject.R
import com.example.practicalproject.mvp.persenter.BasePersenter
import com.example.practicalproject.mvp.view.BaseView

abstract class BaseActivity<V, P : BasePersenter<V>> : AppCompatActivity(), BaseView {
    private var mPersenter: P? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        if (mPersenter == null) {
            mPersenter = createPersenter() as P
        }
        mPersenter!!.bindView(this as V)
        init()
        initData()
    }
    protected abstract fun getLayoutId():Int
    protected abstract fun initData()
    protected abstract fun init()
    protected abstract fun createPersenter():P
    fun getPersenter() = mPersenter
    override fun onDestroy() {
        super.onDestroy()
        mPersenter!!.unBindView()
    }
}