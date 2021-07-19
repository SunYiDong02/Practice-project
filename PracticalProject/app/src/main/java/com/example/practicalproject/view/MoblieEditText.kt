package com.example.practicalproject.view

import android.content.Context
import android.graphics.drawable.Drawable
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.ContextCompat
import com.example.practicalproject.R
import org.w3c.dom.Text

/**
 * @description
 * @author Created by SunYiDong on 2021/7/19 17:43.
 */
class MoblieEditText @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : AppCompatEditText(context, attrs, defStyleAttr), TextWatcher {
    private var draw: Drawable? = null
    private var drawShow: Drawable? = null
    override fun afterTextChanged(s: Editable?) {
        if (TextUtils.isEmpty(text.toString())) {
            isShow(false)
        } else {
            isShow(true)
        }
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        TODO("Not yet implemented")
    }

    override fun onTextChanged(
        text: CharSequence?,
        start: Int,
        lengthBefore: Int,
        lengthAfter: Int
    ) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter)
    }

    init {
        draw = ContextCompat.getDrawable(context, R.drawable.ic_action_delete)
        val minimunWidth: Int = draw!!.minimumWidth
        val minimumHeight: Int = draw!!.minimumHeight
        draw!!.setBounds(0, 0, minimunWidth, minimumHeight)
    }

    private fun isShow(isShow: Boolean) {
        drawShow = if (isShow) {
            draw
        } else {
            null
        }
        setCompoundDrawables(
            compoundDrawables[0],
            compoundDrawables[1],
            drawShow,
            compoundDrawables[3]
        )
    }
}