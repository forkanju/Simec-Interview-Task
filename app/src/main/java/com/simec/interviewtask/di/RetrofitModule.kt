package com.simec.interviewtask.di

import com.simec.interviewtask.utils.Constants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RetrofitModule {


    @Singleton
    @Provides
    fun getRetrofitService(retrofit: Retrofit): ApiServices {
        return retrofit.create(ApiServices::class.java)
    }


    @Singleton
    @Provides
    fun getRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
