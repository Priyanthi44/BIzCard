package com.example.bizcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bizcard.ui.theme.BIzCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BIzCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CreateBizCard(innerPadding)
                }
            }
        }
    }
}

@Composable
fun CreateBizCard(innerPadding: PaddingValues) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Card(
            modifier = Modifier
                .width(200.dp)
                .height(390.dp)
                .padding(innerPadding),
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
            elevation = CardDefaults.cardElevation(4.dp, 4.dp, 4.dp, 4.dp, 4.dp, 4.dp)
        ) {
            Surface(
                modifier = Modifier
                    .size(150.dp)
                    .padding(12.dp),
                shape = CircleShape,

                border = BorderStroke(0.5.dp, Color.LightGray),
                tonalElevation = 4.dp,

            ) {
                Image(
                    painter = painterResource(id = R.drawable.baseline_person_pin_24),
                    contentDescription = "Profile image",

                )
            }
        }
    }


}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BIzCardTheme {
        CreateBizCard(PaddingValues(12.dp))
    }
}