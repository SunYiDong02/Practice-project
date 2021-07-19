package com.example.practicalproject.ui.main.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.practicalproject.R
import com.example.practicalproject.ui.main.activity.RegisterActivity
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
        initView()
    }

    override fun onResume() {
        super.onResume()
        initView()
    }

    private fun initView() {
        tv_jump.setText("test")
        tv_jump.setOnClickListener {
            var intent = Intent(context, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}