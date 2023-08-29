package com.valentinerutto.tourists

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.valentinerutto.tourists.ui.TouristsViewmodel
import com.valentinerutto.tourists.ui.theme.TouristsTheme
import com.valentinerutto.tourists.ui.theme.views.BottomNavigationBar
import com.valentinerutto.tourists.ui.theme.views.NavHost
import com.valentinerutto.tourists.util.NavigationType
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {
//    private val touristsViewmodel:TouristsViewmodel by viewModel()
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TouristsTheme {
                val touristsViewmodel: TouristsViewmodel by inject()

                LaunchedEffect(true) {
                    touristsViewmodel.getTourists()
                    touristsViewmodel.fetchNewsFeed()
                }
                val windowSizeClass = calculateWindowSizeClass(activity = this)
                AppNavigationSetUp(
                    touristsViewmodel = touristsViewmodel, windowSizeClass.widthSizeClass
                )

            }

        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier ) {
//    val touristsViewmodel : TouristsViewmodel
//
//   LaunchedEffect(1) {
//       touristsViewmodel.getTourists()
//       delay(1000)
//   }
//
//    val tourists = touristsViewmodel.tourists.collectAsState().value
//
//    Text(
//        text = "Hello $name!" + tourists.map { it.email }.toString(),
//        modifier = modifier
//    )
}
@Composable
fun AppNavigationSetUp(
    touristsViewmodel: TouristsViewmodel,
    windowWidthSizeClass: WindowWidthSizeClass,
) {
    when (windowWidthSizeClass) {
        WindowWidthSizeClass.Compact -> {
            NavigationType.BOTTOM_NAVIGATION
            BottomNavigationContentSetUp(touristsViewmodel = touristsViewmodel)
        }
            WindowWidthSizeClass.Medium -> {
            NavigationType.NAVIGATION_RAIL
                BottomNavigationContentSetUp(touristsViewmodel = touristsViewmodel)
        }

        WindowWidthSizeClass.Expanded -> {
            NavigationType.PERMANENT_NAVIGATION_DRAWER
         //   BottomNavigationContentSetUp()
        }
        else -> {
            NavigationType.BOTTOM_NAVIGATION
            BottomNavigationContentSetUp(touristsViewmodel = touristsViewmodel)
        }
    }
}
@Composable
fun BottomNavigationContentSetUp(
    touristsViewmodel: TouristsViewmodel,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Row(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = modifier.fillMaxSize()
            ) {
                NavHost(
                    modifier = modifier.weight(1f),
                    navController = navController,
                    touristsViewmodel = touristsViewmodel
                )

                BottomNavigationBar(navController = navController)
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TouristsTheme {
      //  Greeting("Android", touristsViewmodel = TouristsViewmodel)
    }
}