package com.pesquiseme.hotmart.domain

import com.google.gson.Gson
import com.pesquiseme.hotmart.Hotmart
import com.pesquiseme.hotmart.R
import com.pesquiseme.hotmart.data.NetworkUtils
import com.pesquiseme.hotmart.domain.models.ApiResponseError
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.launch
import retrofit2.HttpException

abstract class ApiUseCase<T, in Params>() : UseCase<T, String, Params> {

    companion object {
        fun httpExceptionToApiError(httpException: HttpException): ApiResponseError? {
            return try {
                val body = httpException.response()?.errorBody()
                val bodyJson = body?.string()
                Gson().fromJson(bodyJson, ApiResponseError::class.java)
            } catch (e: Exception) {
                null
            }
        }
    }

    override fun execute(
        params: Params,
        coroutineScope: CoroutineScope,
        onStart: () -> Unit,
        onFinished: () -> Unit,
        onSuccess: (T) -> Unit,
        onFailure: (String) -> Unit,
    ) {
        execute(params, coroutineScope, onStart, onFinished, onSuccess, onFailure, null)
    }

    fun execute(
        params: Params,
        coroutineScope: CoroutineScope,
        onStart: () -> Unit,
        onFinished: () -> Unit,
        onSuccess: (T) -> Unit,
        onFailure: (String) -> Unit,
        onFailureWithResponseError: ((ApiResponseError) -> Unit)?,
    ) {
        onStart()

        if (!NetworkUtils.isConnected(Hotmart.applicationContext())) {
            onFailure(Hotmart.applicationContext().getString(R.string.no_connection))
            onFinished()
        } else {
            coroutineScope.launch {
                try {
                    val result = createDeferredAsync(params).await()
                    onSuccess(onSuccessfullResponse(result))
                } catch (httpException: HttpException) {
                    val responseError = httpExceptionToApiError(httpException)
                    if (responseError != null) {
                        onApiResponseErrorReceived(
                            responseError,
                            onFailure,
                            onFailureWithResponseError
                        )
                    } else {
                        val message = httpException.message() ?: "Error"
                        onFailure(message)
                    }
                } catch (e: Throwable) {
                    val message: String = e.message ?: "Error"
                    onFailure(message)
                }
                onFinished()
            }
        }
    }

    fun onApiResponseErrorReceived(
        apiResponseError: ApiResponseError,
        onFailure: (String) -> Unit,
        onFailureWithResponseError: ((ApiResponseError) -> Unit)?
    ) {
        if (onFailureWithResponseError != null) {
            onFailureWithResponseError(apiResponseError)
        } else {
            onFailure(apiResponseError.message ?: "Error")
        }
    }

    abstract suspend fun createDeferredAsync(params: Params): Deferred<T>

    protected abstract fun onSuccessfullResponse(result: T): T

}