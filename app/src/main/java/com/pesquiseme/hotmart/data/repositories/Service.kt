package com.pesquiseme.hotmart.data.repositories

import com.pesquiseme.hotmart.domain.models.GetLocationsResponse
import com.pesquiseme.hotmart.domain.models.Location
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

interface Service {
    @GET("locations")
    fun getLocations() : Deferred<GetLocationsResponse>

    @GET("locations/{id}")
    fun getLocation(@Path("id") id: String) : Deferred<Location>
}