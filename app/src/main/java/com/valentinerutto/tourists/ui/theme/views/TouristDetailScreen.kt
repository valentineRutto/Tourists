package com.valentinerutto.tourists.ui.theme.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.valentinerutto.tourists.data.local.TouristEntity
import com.valentinerutto.tourists.ui.TouristsViewmodel

@Composable
fun TouristDetailScreen(
    modifier: Modifier = Modifier, touristsViewmodel: TouristsViewmodel = viewModel(),
    touristItemPosition: Int
) {

    val tourists = touristsViewmodel.tourists.collectAsState().value.get(touristItemPosition)

    DetailsHeader(tourist = tourists)
}

@Composable
private fun DetailsHeader(tourist: TouristEntity) {

    Header(tourist.name)
    Spacer(modifier = Modifier.height(16.dp).padding(16.dp))

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 16.dp,
                vertical = 8.dp,
                            ),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            contentAlignment = Alignment.Center,
        ) {

        }

        DetailRow(
            label = "Name",
            value = tourist.name,
        )

        DetailRow(
            label = "Email",
            value = tourist.email
        )

        DetailRow(
            label = "Location",
            value = tourist.location
        )

    }
}


