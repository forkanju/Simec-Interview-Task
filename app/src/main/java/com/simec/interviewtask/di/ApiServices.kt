package com.simec.interviewtask.di

import com.simec.interviewtask.model.RecyclerList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {

    @GET("v3/search/")
    fun getDataFromApi(
        @Query("q") q: String,
        @Query("size") size: Int,
        @Query("page") page: Int,
        @Query("language") language: String,
    ): Call<RecyclerList>?
}
