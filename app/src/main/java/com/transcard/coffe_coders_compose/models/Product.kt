package com.transcard.coffe_coders_compose.models

import com.transcard.coffe_coders_compose.ui.components.CountryISO

data class Product(
    val id: Int,
    val name: String,
    val summary: String,
    val description: String,
    val price: Double,
    val currency: String,
    val countryISO: CountryISO
)