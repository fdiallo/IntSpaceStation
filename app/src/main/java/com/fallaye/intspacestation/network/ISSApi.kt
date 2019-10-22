package com.fallaye.intspacestation.network

import androidx.lifecycle.LiveData
import com.fallaye.intspacestation.models.ISSModel
import io.reactivex.Observable
import retrofit2.http.GET

interface ISSApi {

    @GET("/iss-now.json")
    fun getISSPosition() : LiveData<List<ISSModel>>
}