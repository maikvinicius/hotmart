package com.pesquiseme.hotmart.presentation.di

import com.pesquiseme.hotmart.presentation.home.HomeFragmentViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

object PresentationModule {
    // viewModel
    val presentationModule = module {
        viewModel { HomeFragmentViewModel(get()) }
    }
}