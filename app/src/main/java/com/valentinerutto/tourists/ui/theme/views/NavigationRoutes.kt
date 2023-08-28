package com.valentinerutto.tourists.ui.theme.views

sealed class Screen(val route: String) {
    object TouristsList : Screen("touristsList")
    object TouristDetails : Screen("touristDetails/{touristItemPosition}"){
        fun createRoute(touristItemPosition: Int) = "touristDetails/$touristItemPosition"
    }
    object NewsFeedList : Screen("newsFeedList")

}

