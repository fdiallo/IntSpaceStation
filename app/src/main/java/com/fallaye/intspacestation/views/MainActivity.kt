package com.fallaye.intspacestation.views

//import com.fallaye.intspacestation.databinding.ActivityMainBinding

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.fallaye.intspacestation.R
import com.fallaye.intspacestation.adapter.ISSPositionAdapter
import com.fallaye.intspacestation.viewmodels.ISSPositionViewModel
import com.fallaye.intspacestation.viewmodels.ISSPositionViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class MainActivity : AppCompatActivity(), KodeinAware {

    override val kodein by kodein()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }


    fun getISSPasses(view: View) {

        var latitude = tvLatitude.text.toString().toDouble()
        var longitude = tvLongitude.text.toString().toDouble()
        val issViewModelFactory : ISSPositionViewModelFactory by instance(latitude, longitude)
        var issPositionViewModel : ISSPositionViewModel
        issPositionViewModel = ViewModelProviders.of(this, issViewModelFactory)
            .get(ISSPositionViewModel::class.java)

        recycler_view.layoutManager = LinearLayoutManager(applicationContext)
        recycler_view.setHasFixedSize(true)
        val issPositionAdapter = ISSPositionAdapter(applicationContext, issPositionViewModel.issPositionsList)
        recycler_view.adapter = issPositionAdapter

        tvLatitude.text.clear()
        tvLongitude.text.clear()

    }

    /*fun getISSPasses(view: View) {
        var latitude = tvLatitude.text.toString().toDouble()
        var longitude = tvLongitude.text.toString().toDouble()

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

        tvLatitude.text.clear()
        tvLongitude.text.clear()

    }*/


}
