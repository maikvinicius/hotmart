package com.pesquiseme.hotmart.domain.usecases

import com.pesquiseme.hotmart.data.repositories.Api
import com.pesquiseme.hotmart.domain.ApiUseCase
import com.pesquiseme.hotmart.domain.models.GetLocationsResponse
import com.pesquiseme.hotmart.domain.models.Location
import kotlinx.coroutines.Deferred


class GetLocationDetailUC() : ApiUseCase<Location, GetLocationDetailUC.Params>() {

    class Params(
        val id: String
    )

    override suspend fun createDeferredAsync(params: Params): Deferred<Location> {
        return Api.retrofitService.getLocation(params.id)
    }

    override fun onSuccessfullResponse(result: Location): Location {
        return result
    }

}