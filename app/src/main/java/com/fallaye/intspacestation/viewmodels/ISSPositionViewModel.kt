package com.fallaye.intspacestation.viewmodels

import androidx.lifecycle.ViewModel
import com.fallaye.intspacestation.data.repositories.ISSPositionRepository

class ISSPositionViewModel (
    respository : ISSPositionRepository,
    lat : Double,
    lon : Double
) : ViewModel(){

    var issPositionsList = respository.getISSPostiton(lat, lon)

}