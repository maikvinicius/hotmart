package com.pesquiseme.hotmart.domain.models

data class Week (
    val sunday: OpenClose?,
    val monday: OpenClose?,
    val tuesday: OpenClose?,
    val wednesday: OpenClose?,
    val thursday: OpenClose?,
    val friday: OpenClose?,
    val saturday: OpenClose?
)