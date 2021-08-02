package com.pesquiseme.hotmart.domain.usecases

import com.pesquiseme.hotmart.data.repositories.Api
import com.pesquiseme.hotmart.domain.ApiUseCase
import com.pesquiseme.hotmart.domain.models.GetLocationsResponse
import kotlinx.coroutines.Deferred


class GetLocationUC() : ApiUseCase<GetLocationsResponse, GetLocationUC.Params>() {

    class Params()

    override suspend fun createDeferredAsync(params: Params): Deferred<GetLocationsResponse> {
        return Api.retrofitService.getLocations()
    }

    override fun onSuccessfullResponse(result: GetLocationsResponse): GetLocationsResponse {
        return result
    }

}