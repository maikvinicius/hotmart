package com.pesquiseme.hotmart.domain.models

data class ApiResponseError (
    val code: Int?,
    val message: String?,
    val description: String?
)