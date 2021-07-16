package com.example.practicalproject.mvp.persenter

/**
 * @description
 * @author Created by SunYiDong on 2021/7/15 19:36.
 */
open class BasePersenter<V> {
    private var  mBaseView:V?=null
    fun bindView(mBaseView:V){
        this.mBaseView=mBaseView
    }

    fun unBindView(){
     this.mBaseView=null
    }
    fun getBaseView()=mBaseView
}