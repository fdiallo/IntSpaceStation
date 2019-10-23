package com.fallaye.intspacestation.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.fallaye.intspacestation.R
import com.fallaye.intspacestation.adapter.ISSPositionAdapter
import com.fallaye.intspacestation.data.db.entities.Response
import com.fallaye.intspacestation.data.network.ISSApi
import com.fallaye.intspacestation.data.network.ISSApiClient
import com.fallaye.intspacestation.data.network.responses.ISSPositionResponse
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val latitude = 55.0
        val longitude = -142.3
        //var latidue = tvLatitude.text.toString().toDouble()
        //var longitude = tvLongitude.text.toString().toDouble()

        var issPositionResponse = ISSApiClient.getClient().getISSPosition(latitude, longitude)
        //var issPositionResponse = ISSApiClient.getClient().getISSPosition(100, 1571857710, 45.0, -122.3, 100)
        var issPositionMutLiveDataList = MutableLiveData<List<Response>>()
        var issPositionResponseList : List<Response> = ArrayList()

        issPositionResponse.enqueue(object : Callback, retrofit2.Callback<ISSPositionResponse>{
            override fun onFailure(call: Call<ISSPositionResponse>, t: Throwable) {

            }

            override fun onResponse(
                call: Call<ISSPositionResponse>,
                response: retrofit2.Response<ISSPositionResponse>
            ) {
                issPositionResponseList = response.body()!!.response

                issPositionMutLiveDataList.value = issPositionResponseList

                recycler_view.layoutManager = LinearLayoutManager(applicationContext)
                recycler_view.setHasFixedSize(true)
                val issPositionAdapter = ISSPositionAdapter(applicationContext, issPositionResponseList)
                recycler_view.adapter = issPositionAdapter
            }
        })

    }

}
