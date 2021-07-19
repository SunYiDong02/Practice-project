package com.example.practicalproject.ui.main.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

/**
 * @description
 * @author Created by SunYiDong on 2021/7/19 14:12.
 */
class HomeAdapter(fm:FragmentManager,fragments:ArrayList<Fragment>):FragmentPagerAdapter(fm) {

    private  val fragment:ArrayList<Fragment>?=fragments

    override fun getCount(): Int =fragment!!.size

    override fun getItem(position: Int): Fragment =fragment!!.get(position)
}