package com.valentinerutto.tourists.ui.theme.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.valentinerutto.tourists.data.local.TouristEntity
import com.valentinerutto.tourists.ui.TouristsViewmodel

@Composable
fun TouristsListScreen(
    touristsViewmodel: TouristsViewmodel,
    onTouristSelected: (touristItemPosition: Int) -> Unit,
    modifier: Modifier
) {

   val tourists = touristsViewmodel.tourists.collectAsState().value

    LazyColumn(modifier = Modifier.fillMaxWidth()) {

        item {
            Header("Tourists List")
            Spacer(modifier = Modifier.height(16.dp))

        }
        itemsIndexed(tourists) { index, tourist ->

            TouristItem(
                tourist = tourist,
                modifier = modifier.clickable {
                    onTouristSelected(index)
                }
            )

        }
    }
}

@Composable
fun TouristItem(
    modifier: Modifier,
    tourist: TouristEntity
) {

    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .size(width = 240.dp, height = 100.dp)
    ) {
        Spacer(modifier = Modifier.height(4.dp))
        Text(
                text = tourist.name, fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = tourist.email, fontSize = 16.sp,
                fontWeight = FontWeight.Light
            )
            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = tourist.location, fontSize = 16.sp,
                fontWeight = FontWeight.Light
            )
        }
    }


