package com.pesquiseme.hotmart

import android.app.Application
import com.pesquiseme.hotmart.data.di.DataModule
import com.pesquiseme.hotmart.domain.di.DomainModule
import com.pesquiseme.hotmart.presentation.di.PresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class Hotmart: Application() {

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