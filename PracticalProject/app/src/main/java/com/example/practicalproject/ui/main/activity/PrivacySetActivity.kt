package com.example.practicalproject.ui.main.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.practicalproject.R
import kotlinx.android.synthetic.main.activity_privacy_set.*

class PrivacySetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_privacy_set)
        initView()
    }

    private fun initView() {
        iv_left_back.setOnClickListener { finish()}
    }
}