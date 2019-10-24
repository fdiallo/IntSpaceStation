package com.fallaye.intspacestation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.fallaye.intspacestation.data.repositories.ISSPositionRepository

class ISSPositionViewModelFactory(
    private val repository : ISSPositionRepository,
    private val lat : Double,
    private val lon : Double
) : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ISSPositionViewModel(repository, lat, lon) as T
    }
}