package com.example.practicalproject.ui.main.activity

import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.practicalproject.R
import com.example.practicalproject.base.BaseActivity
import com.example.practicalproject.base.Constants.HOME_BAR
import com.example.practicalproject.ui.main.adapter.HomeAdapter
import com.example.practicalproject.ui.main.fragment.HomeFragment
import com.example.practicalproject.ui.main.fragment.MinVideoFragment
import com.example.practicalproject.ui.main.fragment.MineFragment
import com.example.practicalproject.ui.main.fragment.VideoFragment
import com.example.practicalproject.ui.main.model.TitlsModel
import com.example.practicalproject.ui.main.persenter.MainPersenter
import com.example.practicalproject.ui.main.view.MainView
import com.example.practicalproject.utils.StatusBarUtils
import com.flyco.tablayout.listener.CustomTabEntity
import com.flyco.tablayout.listener.OnTabSelectListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainView, MainPersenter>(), MainView {

    private val titleTabs = ArrayList<CustomTabEntity>()
    private val fragments = ArrayList<Fragment>()

    override fun getLayoutId(): Int = R.layout.activity_main



    override fun initView() {
        StatusBarUtils.setStatusBar(this, HOME_BAR, R.color.theme)
        val titles = resources.getStringArray(R.array.title)
        val selectIds = resources.obtainTypedArray(R.array.select)
        val unSelectIds = resources.obtainTypedArray(R.array.unSelect)
        fragments.add(HomeFragment())
        fragments.add(VideoFragment())
        fragments.add(MinVideoFragment())
        fragments.add(MineFragment())
        for (i in titles.indices) {
            titleTabs.add(
                TitlsModel(
                    titles[i],
                    selectIds.getResourceId(i, 0),
                    unSelectIds.getResourceId(i, 0)
                )
            )
        }

    }
    override fun initData() {
        vp_home.adapter = HomeAdapter(supportFragmentManager, fragments)
        vp_home.offscreenPageLimit = fragments.size
        ctl_home.setTabData(titleTabs)
        ctl_home.setOnTabSelectListener(object : OnTabSelectListener {
            override fun onTabSelect(position: Int) {
                vp_home.setCurrentItem(position, true)
            }

            override fun onTabReselect(position: Int) {
            }

        })
    }
    override fun createPersenter() = MainPersenter()

    override fun <T> setData(data: T) {
        Log.e("test", "================>${data}")
        Toast.makeText(this, "test", Toast.LENGTH_LONG).show()
    }

    override fun setError(error: String) {
    }
}