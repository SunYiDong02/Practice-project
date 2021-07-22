package com.example.practicalproject.view

import android.os.CountDownTimer

/**
 * @description
 * @author Created by SunYiDong on 2021/7/22 10:09.
 */
class AuthCodeTimer(
    millisInFuture: Long,
    countDownInterval: Long,
    mCountDownListener: CountDownListener
) :
    CountDownTimer(millisInFuture, countDownInterval) {
    private val mCountDownListener: CountDownListener = mCountDownListener
    override fun onTick(millisUntilFinished: Long) {
        mCountDownListener.isOverTime(false)
        mCountDownListener.countDown(millisUntilFinished)
    }

    override fun onFinish() {
        mCountDownListener.isOverTime(true)
    }
}