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
 // touristsViewmodel: TouristsViewmodel
) {
  NavHost(
    navController = navController,
    startDestination = Screen.TouristsList.route,
    modifier = modifier
  ) {

    composable(Screen.TouristsList.route) {
//      CharactersListScreen(
//        touristsViewmodel = touristsViewmodel,
//        onCharacterSelected = { characterItemPosition ->
//          val route = Screen.TouristDetails.createRoute(characterItemPosition)
//          navController.navigate(route)
//        },
//        modifier = modifier
//      )
    }

    composable(Screen.TouristDetails.route) { backStackEntry ->
//      val characterItemPosition =
//        backStackEntry.arguments?.getString("characterItemPosition")?.toInt() ?: 0
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