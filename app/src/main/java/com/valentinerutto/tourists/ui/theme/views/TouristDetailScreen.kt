package com.valentinerutto.tourists.ui.theme.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.valentinerutto.tourists.ui.TouristsViewmodel

@Composable
fun TouristDetailScreen(
    modifier: Modifier = Modifier, touristsViewmodel: TouristsViewmodel = viewModel(),
    touristItemPosition: Int
) {

    val tourists = touristsViewmodel.tourists.collectAsState().value.get(touristItemPosition)
//
    Box(modifier = modifier
        .fillMaxSize()
        .fillMaxWidth()
        .fillMaxHeight()) {
//
        Column(modifier = Modifier.padding(32.dp)) {
            Text(
                text = tourists.name,
                style = MaterialTheme.typography.headlineMedium
            )
            Text(text = tourists.email)

        }
    }
}
