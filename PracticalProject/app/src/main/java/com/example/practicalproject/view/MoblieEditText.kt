package com.example.practicalproject.view

import android.content.Context
import android.graphics.drawable.Drawable
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.ContextCompat
import com.example.practicalproject.R
import org.w3c.dom.Text

/**
 * @description
 * @author Created by SunYiDong on 2021/7/19 17:43.
 */
class MoblieEditText @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = R.attr.editTextStyle
) : AppCompatEditText(context, attrs, defStyleAttr) {
    override fun onTextChanged(
        text: CharSequence?,
        start: Int,
        lengthBefore: Int,
        lengthAfter: Int
    ) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter)
    }

    private var draw: Drawable? = null
    private var drawShow: Drawable? = null

    init {
        draw = ContextCompat.getDrawable(context, R.drawable.ic_action_delete)
        val minimunWidth: Int = draw!!.minimumWidth
        val minimumHeight: Int = draw!!.minimumHeight
        draw!!.setBounds(0, 0, minimunWidth, minimumHeight)
        addTextChangedListener(TextWatcherEditText())
        isShow(false)
    }

    private fun isShow(isShow: Boolean) {
        drawShow = if (isShow) {
            draw
        } else {
            null
        }
        setCompoundDrawables(null, null, drawShow, null)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event!!.action == MotionEvent.ACTION_DOWN) {
            var isDelect: Boolean = event.x > (width - compoundPaddingRight) &&
                    event.x < (width - paddingRight) && event.y > 0 && event.y < height
            if (isDelect) {
                setText("")
            }
        }
        return super.onTouchEvent(event)
    }

    private inner class TextWatcherEditText : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            var textContent = s.toString()
            val length = textContent.length
            if (length == 4 || length == 9) {
                if (textContent.substring(length - 1) == " ") {
                    textContent = textContent.substring(0, length - 1)
                    setText(textContent)
                    setSelection(textContent.length)
                } else {
                    textContent = textContent.substring(0, length - 1) + " " + textContent.substring(length - 1)
                    setText(textContent)
                    setSelection(textContent.length)
                }
            }
        }

        override fun afterTextChanged(s: Editable?) {
            if (TextUtils.isEmpty(text.toString())) {
                isShow(false)
            } else {
                isShow(true)
            }
        }

    }
}