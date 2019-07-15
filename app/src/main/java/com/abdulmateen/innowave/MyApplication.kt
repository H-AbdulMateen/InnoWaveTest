package com.abdulmateen.innowave

import android.app.Application
import com.abdulmateen.innowave.data.db.AppDatabase
import com.abdulmateen.innowave.data.network.GitApi
import com.abdulmateen.innowave.data.network.NetworkConnectionInterceptor
import com.abdulmateen.innowave.data.repositories.UserRepository
import com.abdulmateen.innowave.ui.home.profile.ProfileViewModelFactory
import com.abdulmateen.innowave.ui.search.SearchViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class MyApplication : Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidXModule(this@MyApplication))

        bind() from singleton { NetworkConnectionInterceptor(instance()) }
        bind() from singleton { GitApi(instance()) }
        bind() from singleton { AppDatabase(instance()) }
        bind() from singleton { UserRepository(instance(), instance()) }
        bind() from provider { SearchViewModelFactory(instance()) }
        bind() from provider { ProfileViewModelFactory(instance()) }
    }
}