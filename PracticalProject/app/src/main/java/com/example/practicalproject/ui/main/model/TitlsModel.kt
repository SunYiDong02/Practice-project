package com.example.practicalproject.ui.main.model

import com.flyco.tablayout.listener.CustomTabEntity

/**
 * @description
 * @author Created by SunYiDong on 2021/7/19 13:54.
 */
data class TitlsModel(val title: String, val select: Int, val unSelect: Int) : CustomTabEntity {

    override fun getTabTitle(): String = title

    override fun getTabSelectedIcon(): Int = select

    override fun getTabUnselectedIcon(): Int = unSelect
}