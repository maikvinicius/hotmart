package com.pesquiseme.hotmart

import android.app.Application
import android.content.Context
import com.pesquiseme.hotmart.data.di.DataModule
import com.pesquiseme.hotmart.domain.di.DomainModule
import com.pesquiseme.hotmart.presentation.di.PresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class Hotmart: Application() {

    init {
        instance = this
    }

    companion object {
        private var instance: Hotmart? = null

        fun applicationContext() : Context {
            return instance!!.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@Hotmart)
            modules(
                DataModule.dataModule,
                DomainModule.domainModule,
                PresentationModule.presentationModule
            )
        }
    }

}