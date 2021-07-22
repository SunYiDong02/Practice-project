package com.example.practicalproject.view

import android.content.Context
import android.graphics.Color
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import com.example.practicalproject.R
import kotlinx.android.synthetic.main.my_checkbox.view.*

/**
 * @description
 * @author Created by SunYiDong on 2021/7/20 15:43.
 */
class MyCheckBox @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private var isChecked = false
    private var isSelected = R.drawable.ic_action_check
    private var isUnSelected = R.drawable.ic_action_box
    private var mClickableSpanText: ClickableSpanText? = null

    init {
        View.inflate(context, R.layout.my_checkbox, this)
        initSpan()
    }

    private fun initSpan() {
        val span = SpannableString(resources.getString(R.string.agree))
        span.setSpan(object : ClickableSpan() {
            override fun onClick(widget: View) {
                mClickableSpanText?.onClick(1)
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.color = ContextCompat.getColor(context, R.color.theme)
                ds.isUnderlineText = false
            }
        }, 7, 13, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        span.setSpan(object : ClickableSpan() {
            override fun onClick(widget: View) {
                mClickableSpanText?.onClick(2)
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.color = ContextCompat.getColor(context, R.color.theme)
                ds.isUnderlineText = false
            }
        }, 15, 20, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        text.movementMethod = LinkMovementMethod.getInstance()
        text.highlightColor = Color.TRANSPARENT
        text.text = span
    }


    fun changeState() {
        isChecked = !isChecked
        if (isChecked) {
            image.setImageResource(isSelected)
        } else {
            image.setImageResource(isUnSelected)
        }
    }

    fun isChecked(): Boolean = isChecked


    fun setChecked(isChecked: Boolean) {
        this.isChecked = isChecked
        if (isChecked) {
            image.setImageResource(isSelected)
        } else {
            image.setImageResource(isUnSelected)
        }
    }

    interface ClickableSpanText {
        fun onClick(Tpye: Int)
    }


    fun setClickableSpanText(mClickableSpanText:ClickableSpanText) {
        this.mClickableSpanText=mClickableSpanText
    }

}