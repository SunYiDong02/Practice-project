package com.example.practicalproject.ui.main.activity

import android.content.Intent
import android.graphics.Color
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.practicalproject.R
import com.example.practicalproject.base.BaseActivity
import com.example.practicalproject.ui.main.persenter.RegisterPersenter
import com.example.practicalproject.ui.main.view.RegisterView
import com.example.practicalproject.utils.NumUtils
import com.example.practicalproject.view.MyCheckBox
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : BaseActivity<RegisterView, RegisterPersenter>(), TextWatcher,
    RegisterView {

    private var phoneText: String = ""

    override fun getLayoutId(): Int = R.layout.activity_register

    override fun initData() {}

    override fun initView() {
        cd_next.setCardBackgroundColor(Color.parseColor("#222222"))
        checkbox.setChecked(false)
        met_moblie.addTextChangedListener(this)
        checkbox.setOnClickListener {
            checkbox.changeState()
            checkPhone()
        }

        checkbox.setClickableSpanText(object : MyCheckBox.ClickableSpanText {
            override fun onClick(Tpye: Int) {
                if (Tpye == 1) {
                    Toast.makeText(application, "用户协议", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(application, "隐私协议", Toast.LENGTH_SHORT).show()
                }
            }

        })
        cd_next.setOnClickListener {
            if (!checkbox.isChecked()) {
                Toast.makeText(application, "请先勾选协议", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (TextUtils.isEmpty(phoneText)) {
                Toast.makeText(application, "请填写正确电话", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val intent = Intent(this@RegisterActivity, SendCodeActivity::class.java)
            intent.putExtra("MOBLIE", phoneText)
            startActivity(intent)
        }
    }

    override fun <T> setData(data: T) {

    }

    override fun setError(error: String) {
    }

    override fun createPersenter(): RegisterPersenter = RegisterPersenter()

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        phoneText = s.toString()
        checkPhone()
    }

    override fun afterTextChanged(s: Editable?) {
    }

    private fun checkPhone() {
        if (phoneText.length == 13 && checkbox.isChecked()) {
            cd_next.setCardBackgroundColor(ContextCompat.getColor(this, R.color.theme))
        } else {
            cd_next.setCardBackgroundColor(Color.parseColor("#222222"))
        }
    }
}