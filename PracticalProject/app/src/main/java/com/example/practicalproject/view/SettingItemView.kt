package com.example.practicalproject.view

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import com.example.practicalproject.R
import kotlinx.android.synthetic.main.item_setting_view.view.*

/**
 * @description
 * @author Created by SunYiDong on 2021/7/30 15:10.
 */
class SettingItemView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    private var leftTitle: String? = ""
    private var rightTitle: String? = ""
    private var contentTitle: String? = ""
    private var isShowButton: Boolean? = false
    private var isShowImage: Boolean? = false
    private val settingArray: TypedArray =
        context.obtainStyledAttributes(attrs, R.styleable.SettingsItem)

    init {
        leftTitle = settingArray.getString(R.styleable.SettingsItem_leftTitle)
        rightTitle = settingArray.getString(R.styleable.SettingsItem_rightTitle)
        contentTitle = settingArray.getString(R.styleable.SettingsItem_contentTitle)
        isShowButton = settingArray.getBoolean(R.styleable.SettingsItem_isShowButton, false)
        isShowImage = settingArray.getBoolean(R.styleable.SettingsItem_isShowImage, false)
        settingArray.recycle()
        initView()
    }

    private fun initView() {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_setting_view, this)
        view.left_title.text = leftTitle
        view.right_title.text = rightTitle
        view.content_title.text = contentTitle
        isShowBtn(view)
        isShowImage(view)
    }

    private fun isShowBtn(view: View) {
        if (isShowButton == true) {
            view.btn_off.visibility = View.GONE
        } else
            view.btn_off.visibility = View.VISIBLE
    }

    private fun isShowImage(view: View) {
        if (isShowImage == true) {
            view.iv_right_back.visibility = View.GONE
        } else
            view.iv_right_back.visibility = View.VISIBLE
    }

    fun setBgSetItem(view: View,colorIds:Int){
        view!!.setBackgroundColor(ContextCompat.getColor(context,colorIds))
    }
}