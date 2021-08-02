package com.pesquiseme.hotmart.data.repositories

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.pesquiseme.hotmart.BuildConfig
import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object Api {
    val retrofitService: Service by lazy {
        service.create(Service::class.java)
    }
}

var readTimeoutSeconds = 200L
var callTimeoutSeconds = 200L

val baseUrl_profiles = (BuildConfig.BASE_URL).toHttpUrl()

var service: Retrofit = buildRetrofit(baseUrl_profiles)

fun buildRetrofit(baseUrl: HttpUrl): Retrofit {
    return Retrofit.Builder()
        .baseUrl(baseUrl)
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .addConverterFactory(GsonConverterFactory.create())
        .client(buildRetrofitClient())
        .build()
}

fun buildRetrofitClient() : OkHttpClient {
    return OkHttpClient.Builder()
        .readTimeout(readTimeoutSeconds, TimeUnit.SECONDS)
        .callTimeout(callTimeoutSeconds, TimeUnit.SECONDS)
        .build()
}
