package com.valentinerutto.tourists.ui.theme.views

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import com.valentinerutto.tourists.R

@Composable
fun BottomNavigationBar(navController: NavController, modifier: Modifier = Modifier) {
    NavigationBar(
        modifier = modifier.fillMaxWidth(),
        containerColor = MaterialTheme.colorScheme.background
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        NavigationBarItem(
            selected = currentDestination?.hierarchy?.any { it.route == Screen.TouristsList.route } == true,
            onClick = {
                navController.navigate(Screen.TouristsList.route) {
                    popUpTo(Screen.TouristsList.route) {
                        inclusive = true
                    }
                }
            },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_user),
                    contentDescription = stringResource(id = R.string.tourists)
                )
            },
            label = { Text(text = "Tourists") }
        )

        NavigationBarItem(
            selected = currentDestination?.hierarchy?.any { it.route == Screen.NewsFeedList.route } == true,
            onClick = {
                navController.navigate(Screen.NewsFeedList.route) {
                    popUpTo(Screen.NewsFeedList.route) {
                        inclusive = true
                    }
                }
            },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_news),
                    contentDescription = stringResource(id = R.string.newsfeed)
                )
            },
            label = { Text(text = "News") }

        )

    }
}
