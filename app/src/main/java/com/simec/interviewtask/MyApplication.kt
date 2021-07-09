package com.simec.interviewtask

import android.app.Application
import com.simec.interviewtask.di.DaggerRetrofitComponent
import com.simec.interviewtask.di.RetrofitComponent
import com.simec.interviewtask.di.RetrofitModule

class MyApplication : Application() {
    private lateinit var retrofitComponent: RetrofitComponent

    override fun onCreate() {
        super.onCreate()

        retrofitComponent = DaggerRetrofitComponent.builder()
            .retrofitModule(RetrofitModule())
            .build()
    }

    fun getRetrofitComponent(): RetrofitComponent{
        return retrofitComponent
    }
}
