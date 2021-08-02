package com.pesquiseme.hotmart.domain.di

import com.pesquiseme.hotmart.domain.usecases.GetLocationDetailUC
import com.pesquiseme.hotmart.domain.usecases.GetLocationUC
import org.koin.dsl.module

object DomainModule {
    // factory
    val domainModule = module {
        factory { GetLocationUC() }
        factory { GetLocationDetailUC() }
    }
}