package com.transcard.coffe_coders_compose.utils

import com.transcard.coffe_coders_compose.models.Product
import com.transcard.coffe_coders_compose.ui.components.CountryISO

class MockDataProvider {

    companion object {
        fun getListOfProducts(): List<Product> {
            return listOf(
                Product(
                    id = 1,
                    name = "Café de Colombia",
                    summary = "CO It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.",
                    description = "CO There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text",
                    price = 35.0,
                    currency = "USD",
                    countryISO = CountryISO.COL
                ),
                Product(
                    id = 2,
                    name = "Café de Nicaragua",
                    summary = "NIC It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.",
                    description = "NIC There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text",
                    price = 30.0,
                    currency = "USD",
                    countryISO = CountryISO.NIC
                ),
                Product(
                    id = 3,
                    name = "Café de Costa Rica",
                    summary = "CRI It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.",
                    description = "CRI There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text",
                    price = 38.0,
                    currency = "USD",
                    countryISO = CountryISO.CRI
                ),
                Product(
                    id = 4,
                    name = "BRA Café de Brasil",
                    summary = "BRA It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.",
                    description = "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text",
                    price = 34.0,
                    currency = "USD",
                    countryISO = CountryISO.BRA
                )
            )
        }

        fun getCities(): List<String> {
            return listOf(
                "Mexico City, Mexico",
                "The Habana, Cuba",
                "Cancun, Mexico",
                "Medellin, Colombia",
                "Buenos Aires, Argentina",
                "Sao Paulo, Brasil",
                "Lima, Peru",
                "Montevideo, Uruguay",
                "Panama City, Panama"
            )
        }

        fun getProductBy(id: Int): Product? {
            return getListOfProducts().firstOrNull { p-> p.id == id }
        }
    }
}