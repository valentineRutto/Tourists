package com.valentinerutto.tourists.ui.theme.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.valentinerutto.tourists.data.local.NewsFeedEntity
import com.valentinerutto.tourists.data.local.TouristEntity
import com.valentinerutto.tourists.ui.TouristsViewmodel

@Composable
fun NewsFeedListScreen(touristsViewmodel: TouristsViewmodel,
                       modifier: Modifier) {

    LaunchedEffect(true) {
        touristsViewmodel.getTourists()
    }

    val news = touristsViewmodel.news.collectAsState().value

    LazyColumn(modifier = Modifier.fillMaxWidth()) {

        itemsIndexed(news) { index, newsfeed ->

            NewsItem(
                news = newsfeed,
                modifier = modifier
            )
        }
    }


}
@Composable
fun NewsItem(
    modifier: Modifier,
    news: NewsFeedEntity
) {

    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = modifier.fillMaxWidth().padding(8.dp)
            .size(width = 240.dp, height = 100.dp)
    ) {
        Spacer(modifier = Modifier.height(4.dp))
        ImageComposable(
imageUrl = news.multimediaUrl        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = news.title, fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = news.description, fontSize = 16.sp,
            fontWeight = FontWeight.Light
        )
        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = news.userName, fontSize = 16.sp,
            fontWeight = FontWeight.Light
        )
    }
}

