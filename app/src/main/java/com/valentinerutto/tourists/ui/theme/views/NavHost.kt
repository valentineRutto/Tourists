package com.valentinerutto.tourists.ui.theme.views

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.valentinerutto.tourists.ui.TouristsViewmodel

@Composable
fun NavHost(
  modifier: Modifier = Modifier,
  navController: NavHostController = rememberNavController(),
  touristsViewmodel: TouristsViewmodel
) {
  NavHost(
    navController = navController,
    startDestination = Screen.TouristsList.route,
    modifier = modifier
  ) {

    composable(Screen.TouristsList.route) {


        TouristsListScreen(
            touristsViewmodel = touristsViewmodel,
        onTouristSelected = { touristItemPosition ->
          val route = Screen.TouristDetails.createRoute(touristItemPosition)
          navController.navigate(route)
        },
        modifier = modifier
      )
    }

    composable(Screen.TouristDetails.route) { backStackEntry ->
     val touristItemPosition =
        backStackEntry.arguments?.getString("touristItemPosition")?.toInt() ?: 0
//      CharacterDetailsScreen(
//        characterViewModel = characterViewModel,
//        characterItemPosition = characterItemPosition
//      )
    }

    composable(Screen.NewsFeedList.route) {
    //  LocationsScreen()
    }

  }
}