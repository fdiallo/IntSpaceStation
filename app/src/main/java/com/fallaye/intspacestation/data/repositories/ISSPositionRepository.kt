package com.fallaye.intspacestation.data.repositories

import com.fallaye.intspacestation.data.db.entities.Response
import com.fallaye.intspacestation.data.network.ISSApi
import com.fallaye.intspacestation.data.network.responses.ISSPositionResponse
import retrofit2.Call
import javax.security.auth.callback.Callback


class ISSPositionRepository(
    private val issApi : ISSApi
    //private val issDB : AppDatabase
) {

    fun getISSPostiton(lat : Double, lon : Double) : List<Response> {

        var issPositionResponseList : List<Response> = ArrayList<Response>()

        issApi.getISSPosition(lat, lon).enqueue(object : Callback, retrofit2.Callback<ISSPositionResponse> {
            override fun onFailure(call: Call<ISSPositionResponse>, t: Throwable) {

            }
            override fun onResponse(
                call: Call<ISSPositionResponse>,
                response: retrofit2.Response<ISSPositionResponse>
            ) {
                issPositionResponseList = response.body()!!.response
            }
        })
        return issPositionResponseList

    }

    /*suspend fun getISSPostitons() : LiveData<ListResponse> {}*/

}
