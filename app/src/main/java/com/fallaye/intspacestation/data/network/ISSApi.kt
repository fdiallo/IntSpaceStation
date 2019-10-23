package com.fallaye.intspacestation.data.network

import com.fallaye.intspacestation.data.db.entities.ISSPosition
import com.fallaye.intspacestation.data.network.responses.ISSPositionResponse
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET

interface ISSApi {

    @GET("/iss-now.json")
    fun getISSPosition() : Call<ISSPositionResponse>
}