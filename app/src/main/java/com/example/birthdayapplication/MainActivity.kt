package com.example.birthdayapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
//import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.birthdayapplication.ui.theme.BirthdayApplicationTheme
//import java.util.*

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
                                            R.string.birthday_wish_from) , getString(R.string.birthday_date))
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
fun GreetingWithImage(name: String , wish: String , from: String ,  date: String){
    val image = painterResource(id = R.drawable.birthdayimage)

    Box{
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .blur(4.dp),
            contentScale = ContentScale.Crop
        )
        GreetingWithText(name = name, wish = wish, from = from ,  date = date)

    }

}

@Composable
fun GreetingWithText( name: String , wish: String , from: String , date: String) {
            Column{
                Text(text = "Happy Birthday \uD83C\uDF82 $name! ",
                    fontSize = 30.sp,
                    fontFamily = FontFamily.Monospace,
                    color = Color.Black,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.CenterHorizontally)
//                        .wrapContentHeight(Alignment.CenterVertically)
                        .padding(start = 24.dp,  end = 24.dp , top= 24.dp )
                )
                Text(text = "$date 🐣",
                    fontSize = 18.sp,
                    color = Color.Black,
                    fontFamily = FontFamily.Monospace,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.CenterHorizontally)
//                        .wrapContentHeight(Alignment.CenterVertically)
                        .padding(start = 14.dp, top = 10.dp , end = 24.dp)
                )

                Text(text = wish ,
                    fontSize = 24.sp,
                    color = Color.Black,
                    fontFamily = FontFamily.Cursive,
                    modifier = Modifier
                        .padding(top= 100.dp , start = 24.dp , end= 24.dp)
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.CenterHorizontally)
                        .wrapContentHeight(Alignment.CenterVertically)

                )


                Text(text = "From \n$from" ,
                    fontSize = 20.sp,
                    color = Color.Black,
                    modifier = Modifier
                        .fillMaxHeight()
                        .wrapContentHeight(Alignment.Bottom)
                        .padding(bottom = 150.dp, start = 24.dp , end = 100.dp)
                )
            }
    }



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BirthdayApplicationTheme {
        GreetingWithImage(wish = "Stay blessed! Stay Hydrated! Hope you have a wonderfull life ahead and full of prosperity and goodwill . :)" ,
            from = "Aman Kumar Singh" ,
            name = "Google Developers" , date = "29 March 2003" )
    }
}