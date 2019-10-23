package com.fallaye.intspacestation.data.network

import com.fallaye.intspacestation.data.network.responses.ISSPositionResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ISSApi {

    @GET("/iss-pass.json")
    fun getISSPosition(
        @Query("lat") latitude : Double,
        @Query("lon") longitude : Double
    ) : Call<ISSPositionResponse>
}