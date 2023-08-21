package com.valentinerutto.tourists

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.valentinerutto.tourists.ui.TouristsViewmodel
import com.valentinerutto.tourists.ui.theme.TouristsTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    private val touristsViewmodel by viewModel<TouristsViewmodel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TouristsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android",modifier = Modifier,touristsViewmodel)
                }
            }
            LaunchedEffect(true) {
                touristsViewmodel.getTourists()
            }

        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier ,touristsViewmodel: TouristsViewmodel) {
    val tourists = touristsViewmodel.tourists.collectAsState().value

    Text(
        text = "Hello $name!" + tourists.map { it.email }.toString(),
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TouristsTheme {
      //  Greeting("Android", touristsViewmodel = TouristsViewmodel)
    }
}