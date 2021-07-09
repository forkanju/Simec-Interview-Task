package com.simec.interviewtask

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.simec.interviewtask.di.ApiServices
import com.simec.interviewtask.model.RecyclerList
import com.simec.interviewtask.model.Results
import com.simec.interviewtask.model.Translations
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MainViewModel(application: Application) : AndroidViewModel(application) {
    @Inject
    lateinit var mService: ApiServices

    private lateinit var liveDataList: MutableLiveData<RecyclerList>
    private lateinit var liveDataTranslations: MutableLiveData<Results>

    init {
        //here we need to init application
        (application as MyApplication).getRetrofitComponent().inject(this)
        liveDataList = MutableLiveData()
        liveDataTranslations = MutableLiveData()
    }

    fun getLiveDataObserver(): MutableLiveData<RecyclerList> {
        return liveDataList
    }

    fun getLiveDataTranslationsObserver(): MutableLiveData<Results> {
        return liveDataTranslations
    }


    fun makeApiCall() {
        val call: Call<RecyclerList>? = mService.getDataFromApi("quran", 20, 0, "en")
        call?.enqueue(object : Callback<RecyclerList> {
            override fun onFailure(call: Call<RecyclerList>, t: Throwable) {
                liveDataList.postValue(null)
                Log.e("Simec", "fail data")
            }

            override fun onResponse(call: Call<RecyclerList>, response: Response<RecyclerList>) {
                if (response.isSuccessful) {
                    liveDataList.postValue(response.body())
                    Log.e("Simec", "fail data"+ response.body())
                } else {
                    liveDataList.postValue(null)
                    Log.e("Simec", "fail data res")
                }

            }
        })
    }
}

