package com.pesquiseme.hotmart.domain.models

data class Location(
    val id: Int,
    val name: String,
    var review: Double,
    val type: String,
    val about: String,
    val schedule: List<Week>,
    val phone: String,
    val adress: String
)