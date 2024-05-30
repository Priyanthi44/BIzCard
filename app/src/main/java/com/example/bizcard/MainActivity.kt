package com.example.bizcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
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
    val buttonClickedState = remember {
        mutableStateOf(true)
    }
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = Modifier
                    .width(400.dp)
                    .fillMaxHeight()
                    .padding(innerPadding),
                shape = RoundedCornerShape(corner = CornerSize(15.dp)),
                elevation = CardDefaults.cardElevation(4.dp, 4.dp, 4.dp, 4.dp, 4.dp, 4.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CreateProfilePic(modifier = Modifier
                        .size(150.dp)
                        .padding(12.dp))
                    Divider(
                        thickness = 3.dp
                    )
                    CreateProfileInfo()
                    Button(onClick = {
                        buttonClickedState.value = !buttonClickedState.value

                    }) {
                        CreateText(
                            tfontsize = MaterialTheme.typography.labelLarge,
                            tcolor = Color.White,
                            text = "Portfolio"
                        )


                    }
                    if (!buttonClickedState.value) {
                        ContentList()
                    } else {
                        Box{}
                    }
                }

            }
        }

    }


}

@Composable
private fun CreateProfileInfo() {
    Column(
        modifier = Modifier.padding(0.5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CreateText(
            MaterialTheme.typography.headlineLarge, Color.Blue, "Miles P."
        )
        CreateText(
            MaterialTheme.typography.bodyLarge,
            Color.Black,
            "Android Compose Programmer"
        )
        CreateText(MaterialTheme.typography.labelLarge, Color.Black, "@themilesCompose")
    }
}

@Composable
fun CreateText(tfontsize: TextStyle, tcolor: Color, text: String) {
    Text(text = text, color = tcolor, style = tfontsize)
}

@Composable
fun CreateProfilePic(modifier: Modifier) {
    Surface(
        modifier = modifier,
        shape = CircleShape,

        border = BorderStroke(0.5.dp, color = Color.White),
        tonalElevation = 4.dp,

        ) {
        Image(
            painter = painterResource(id = R.drawable.baseline_person_pin_24),
            contentDescription = "Profile image",

            )
    }
}

@Preview(showBackground = true)
@Composable
fun ContentList() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp),
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(3.dp),
            shape = RoundedCornerShape(corner = CornerSize(6.dp)),
            border = BorderStroke(2.dp, Color.White)
        ) {
            Portforlio(data = listOf("Project 1", "Project 2", "Project 3"))
        }
    }

}

@Composable
fun Portforlio(data: List<String>) {
    LazyColumn {
        items(data) {
            Card(
                modifier = Modifier
                    .padding(5.dp)
                    .fillParentMaxWidth(),
                shape = RectangleShape
            ) {
                Row(
                    modifier = Modifier.padding(8.dp),
                ) {
                        CreateProfilePic(modifier = Modifier
                            .size(50.dp)
                            .padding(3.dp))
                    Column (modifier = Modifier.padding(7.dp).align(alignment = Alignment.CenterVertically)) {
                        Text(it, fontWeight = FontWeight.Bold)
                        Text("great project")
                    }

                }


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