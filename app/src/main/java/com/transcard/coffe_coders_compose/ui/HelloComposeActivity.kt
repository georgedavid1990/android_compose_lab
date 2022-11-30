package com.transcard.coffe_coders_compose.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.transcard.coffe_coders_compose.R
import com.transcard.coffe_coders_compose.ui.theme.Coffee_coders_composeTheme
import com.transcard.coffe_coders_compose.ui.theme.PlatziBlue
import com.transcard.coffe_coders_compose.ui.theme.TitleText

class HelloComposeActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Hello()
        }
    }

    @Composable
    private fun Hello() {
        Coffee_coders_composeTheme() {
            Card(
                elevation = 4.dp,
                shape = MaterialTheme.shapes.large,
                backgroundColor = PlatziBlue
            ) {
                Column(
                    modifier = Modifier.padding(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.platzi),
                        contentDescription = "Hello compose",
                        modifier = Modifier.size(40.dp, 40.dp)
                    )
                    Text(
                        text = "Compose course from Platzi...",
                        style = MaterialTheme.typography.h4,
                    )
                    Text(
                        text = "Jet Pack compose course...",
                        style = MaterialTheme.typography.body1
                    )
                    Button(
                        onClick = {  },
                        modifier = Modifier.padding(top = 16.dp),
                        shape = MaterialTheme.shapes.large
                    ) {
                        Text(text = "Press me",
                        style = MaterialTheme.typography.body2)
                    }
                }
            }
        }
    }

    @Preview(showBackground = false)
    @Composable
    private fun Preview() {
        Hello()
    }
}