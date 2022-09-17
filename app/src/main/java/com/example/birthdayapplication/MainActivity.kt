package com.example.birthdayapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.birthdayapplication.ui.theme.BirthdayApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BirthdayApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                ) {
                    GreetingWithImage(getString(R.string.birthday_person_name) , getString(R.string.birthday_wish) , getString(
                                            R.string.birthday_wish_from))
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun GreetingWithImage(name: String , wish: String , from: String){
    val image = painterResource(id = R.drawable.birthdayimage)

    Box(){
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        GreetingWithText(name = name, wish = wish, from = from )

    }

}

@Composable
fun GreetingWithText( name: String , wish: String , from: String) {
            Column{
                Text(text = "Happy Birthday $name!",
                    fontSize = 36.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.Start)
                        .padding(start = 24.dp, top = 30.dp)
                )
                Text(text = "$wish" , modifier = Modifier.padding(24.dp).
                wrapContentWidth(Alignment.Start))
                Text(text = "-From $from" ,
                    fontSize = 16.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(top = 400.dp ,  start = 24.dp)
                )
            }
    }



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BirthdayApplicationTheme {
        GreetingWithImage(wish = "Stay blessed! Stay Hydrated!" ,
            from = "Abhishek Kushwaha" ,
            name = "Google Developers" )
    }
}