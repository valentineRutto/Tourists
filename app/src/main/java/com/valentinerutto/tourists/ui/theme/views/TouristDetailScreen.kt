package com.valentinerutto.tourists.ui.theme.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.valentinerutto.tourists.ui.TouristsViewmodel

@Composable
fun TouristDetailScreen(touristsViewmodel: TouristsViewmodel = viewModel(),
                        touristItemPosition:Int) {
  Column(){
        Text(
            text = "tourist.name",
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp
        )
    }
}