package com.example.practicalproject.http

import com.example.practicalproject.base.Constants.BASE_URL
import com.example.practicalproject.base.Constants.BASE_URL_TEST
import com.orhanobut.logger.Logger
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @description
 * @author Created by SunYiDong on 2021/7/16 11:43.
 */
object HttpUtils {


    private var mOkhttp: OkHttpClient? = null
    private fun isTest(isTest: Boolean): String = if (isTest) BASE_URL_TEST else BASE_URL
    fun <T> createApi(clazz: Class<T>): T = Retrofit.Builder()
        .baseUrl(isTest(true))
        .client(getClient())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(clazz)

    private fun getClient(): OkHttpClient? {
        if (mOkhttp == null) {
            mOkhttp = OkHttpClient().newBuilder()
                .addInterceptor(getInterceptor())
                .retryOnConnectionFailure(true)
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .build()
        }
        return mOkhttp
    }

    private fun getInterceptor(): Interceptor {
        HttpLoggingInterceptor.Logger {
            Logger.json(it)
        }
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    public fun <T> sendHttp(ob: Observable<T>, listenter: ResponseListenter<T>) {
        ob.subscribeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<T> {
                override fun onSubscribe(d: Disposable) {
                }

                override fun onNext(t: T) {
                    listenter!!.onSuccess(t)
                }

                override fun onError(e: Throwable) {
                    listenter!!.onFail(e.message.toString())
                }

                override fun onComplete() {
                }

            })

    }
}


