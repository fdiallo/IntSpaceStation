package com.fallaye.intspacestation.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.fallaye.intspacestation.R
import com.fallaye.intspacestation.adapter.ISSPositionAdapter
import com.fallaye.intspacestation.data.db.entities.ISSPosition
import com.fallaye.intspacestation.data.network.ISSApi
import com.fallaye.intspacestation.data.network.ISSApiClient
import com.fallaye.intspacestation.data.network.responses.ISSPositionResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.internal.schedulers.IoScheduler
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val issApiClient : ISSApi = ISSApiClient.getClient()
        var issResponse = issApiClient.getISSPosition()
        Log.d("ISS List:", issResponse.toString())
       /* issResponse.observeOn(AndroidSchedulers.mainThread()).subscribeOn(IoScheduler()).subscribe {issResponse
            recycler_view.adapter = ISSPositionAdapter(this,  issResponse.)
        }*/
        var issPositionList = ArrayList<ISSPosition>()
        var issPositionMutLiveDataList = MutableLiveData<List<ISSPosition>>()
        //var issPosition : ISSPosition
        var issPositionResponse : ISSPositionResponse? = null
        issResponse.enqueue(object: Callback,
            retrofit2.Callback<ISSPositionResponse> {
            override fun onFailure(call: Call<ISSPositionResponse>, t: Throwable) {

            }
            override fun onResponse(
                call: Call<ISSPositionResponse>,
                response: Response<ISSPositionResponse>
            ) {
                issPositionResponse = response.body()
                val issPosition = issPositionResponse?.iss_position
                Log.d("ISS Position: ", issPosition.toString())
                issPositionList.add(issPosition!!)
                issPositionMutLiveDataList.value = issPositionList

                recycler_view.layoutManager = LinearLayoutManager(applicationContext)
                recycler_view.setHasFixedSize(true)
                val issPositionAdapter = ISSPositionAdapter(applicationContext, issPositionList)
                recycler_view.adapter = issPositionAdapter
            }

        })






    }
}
