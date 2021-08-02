package com.pesquiseme.hotmart.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pesquiseme.hotmart.domain.models.Location
import com.pesquiseme.hotmart.domain.usecases.GetLocationDetailUC

class DetailActivityViewModel(
    private val getLocationDetailUC: GetLocationDetailUC
): ViewModel() {

    private val _location: MutableLiveData<Location> = MutableLiveData(null)
    val location: LiveData<Location> get() = _location

    private val _error: MutableLiveData<String> = MutableLiveData(null)
    val error: LiveData<String> = _error

    private val _loading: MutableLiveData<Boolean> = MutableLiveData(false)
    val loading: LiveData<Boolean> = _loading

    fun getLocation(id: String) {
        getLocationDetailUC.execute(
            GetLocationDetailUC.Params(id), viewModelScope,
            onStart = {
                _loading.value = true
            },
            onFinished = {
                _loading.value = false
            },
            onSuccess = {location ->
                _location.value = location
            },
            onFailure = {error ->
                _error.value = error
            }
        )
    }

}