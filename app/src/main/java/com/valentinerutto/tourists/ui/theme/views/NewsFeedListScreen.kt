package com.valentinerutto.tourists.ui.theme.views

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import com.valentinerutto.tourists.data.local.NewsFeedEntity
import com.valentinerutto.tourists.ui.TouristsViewmodel

@Composable
fun NewsFeedListScreen(touristsViewmodel: TouristsViewmodel,
                       modifier: Modifier) {

    val news = touristsViewmodel.news.collectAsState().value
    LazyColumn(modifier = Modifier.fillMaxSize()) {

        item {
            Header("News Feed List")
            Spacer(modifier = Modifier.height(16.dp))

        }
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
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp).fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(4.dp).padding(16.dp))
        ImageComposable(imageUrl = news.userPPic)

        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = news.title?:"not available", fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = news.description?:"not available", fontSize = 16.sp,
            fontWeight = FontWeight.Light
        )
        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = news.userName, fontSize = 16.sp,
            fontWeight = FontWeight.Light
        )
    }
}

