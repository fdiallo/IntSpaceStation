package com.fallaye.intspacestation

import android.app.Application
import com.fallaye.intspacestation.data.network.ISSApiClient
import com.fallaye.intspacestation.data.repositories.ISSPositionRepository
import com.fallaye.intspacestation.viewmodels.ISSPositionViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

class ISSPositionApplication : Application(), KodeinAware{
    override val kodein = Kodein.lazy {
        import(androidXModule(this@ISSPositionApplication))

        bind() from singleton { Double }
        bind() from singleton { ISSApiClient }
        bind() from singleton { ISSPositionRepository(instance())}
        bind() from singleton { ISSPositionViewModelFactory(instance(), instance(), instance())}

    }


}