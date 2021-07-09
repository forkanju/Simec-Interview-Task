package com.simec.interviewtask.di

import com.simec.interviewtask.MainViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RetrofitModule::class])
interface RetrofitComponent {
    fun inject(mainViewModel: MainViewModel)
}
