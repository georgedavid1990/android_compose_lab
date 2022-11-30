package com.transcard.coffe_coders_compose.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.transcard.coffe_coders_compose.R
import com.transcard.coffe_coders_compose.models.Product
import com.transcard.coffe_coders_compose.ui.theme.Coffee_coders_composeTheme
import com.transcard.coffe_coders_compose.ui.theme.PlatziBlue
import com.transcard.coffe_coders_compose.ui.theme.PlatziGreen
import com.transcard.coffe_coders_compose.utils.MockDataProvider

enum class CountryISO(val iso: String){
    COL("COL"),
    BRA("BRA"),
    CRI("CRI"),
    NIC("NIC");

    fun getBackgroundImage(): Int {
        return when(this){
            COL -> R.drawable.co
            BRA -> R.drawable.br
            CRI -> R.drawable.ri
            NIC -> R.drawable.ni
        }
    }

    fun getFlag(): Int {
        return when(this){
            COL -> R.drawable.flagco
            BRA -> R.drawable.flagbr
            CRI -> R.drawable.flagri
            NIC -> R.drawable.flagni
        }
    }

    fun getSurface(): Color {
        return when(this){
            COL, CRI -> PlatziBlue
            BRA, NIC -> PlatziGreen
        }
    }
}

@Composable
fun ProductCard(product: Product,
                select: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable {
                select()
            }
            .size(480.dp),
        elevation = 10.dp,
        shape = MaterialTheme.shapes.small
    ) {
        Image(
            painter = painterResource(id = product.countryISO.getBackgroundImage()),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = product.countryISO.getSurface().copy(0.2f)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = product.name,
                    style = MaterialTheme.typography.h4
                )
                Text(
                    text = product.summary,
                    style = MaterialTheme.typography.body1
                )
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Bottom
                ) {

                    Row {
                        Image(
                            painter = painterResource(id = product.countryISO.getFlag()),
                            contentDescription = null,
                            modifier = Modifier.size(32.dp, 32.dp)
                        )

                        Text(
                            text = "$ ${product.price} ${product.currency}",
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.End,
                            style = MaterialTheme.typography.h4
                        )
                    }

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductCardPreview() {
    Coffee_coders_composeTheme {
        MockDataProvider.getProductBy(1)?.let {
            ProductCard(it){}
        }
    }
}