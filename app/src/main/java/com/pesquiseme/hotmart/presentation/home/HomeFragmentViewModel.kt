package com.pesquiseme.hotmart.presentation.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pesquiseme.hotmart.domain.models.Location
import com.pesquiseme.hotmart.domain.usecases.GetLocationUC

class HomeFragmentViewModel(
    private val getLocationUC: GetLocationUC
) : ViewModel() {

    private val _locations: MutableLiveData<List<Location>> = MutableLiveData(null)
    val locations: LiveData<List<Location>> = _locations

    private val _error: MutableLiveData<String> = MutableLiveData(null)
    val error: LiveData<String> = _error

    private val _loading: MutableLiveData<Boolean> = MutableLiveData(false)
    val loading: LiveData<Boolean> = _loading

    init {
        getLocations()
    }

    private fun getLocations() {
        getLocationUC.execute(
            GetLocationUC.Params(), viewModelScope,
            onStart = {
                _loading.value = true
            },
            onFinished = {
                _loading.value = false
            },
            onSuccess = {locations ->
                _locations.value = locations.listLocations
            },
            onFailure = {error ->
                _error.value = error
            }
        )
    }

}