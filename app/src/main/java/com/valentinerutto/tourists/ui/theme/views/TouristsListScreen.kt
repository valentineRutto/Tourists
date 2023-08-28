package com.valentinerutto.tourists.ui.theme.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
    
    LaunchedEffect(true) {
        touristsViewmodel.getTourists()
    }

   val tourists = touristsViewmodel.tourists.collectAsState().value
    LazyColumn(modifier = Modifier.fillMaxWidth()) {

        item {
              Text("Tourists")
            Spacer(modifier = Modifier.height(16.dp))
        }

        itemsIndexed(tourists) { index, tourist ->

            TouristItem(
                modifier = modifier.clickable {
                    onTouristSelected(index)
                },
                tourist = tourist
            )

        }
    }
}

@Composable
fun TouristItem(
    modifier: Modifier,
    tourist: TouristEntity
) {
    Card(
        shape = RoundedCornerShape(14.dp), colors = CardDefaults.cardColors(
            containerColor =
            MaterialTheme.colorScheme.onTertiaryContainer
        ),
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(), elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp
        )
    ) {

        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {

//            CharacterImageComposable(
//                imageUrl = character.image,
//                Modifier
//                    .size(80.dp, 80.dp)
//                    .clip(RoundedCornerShape(16.dp))
//            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.align(Alignment.CenterVertically)) {

                Text(text = "character.name", fontSize = 16.sp)

                Spacer(modifier = Modifier.height(8.dp))

                Text(text = "character.status", fontSize = 16.sp)

            }

        }
    }
}