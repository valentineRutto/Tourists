package com.valentinerutto.tourists.ui.theme.views

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import coil.compose.AsyncImage
import com.valentinerutto.tourists.R

@Composable
fun ImageComposable(
    imageUrl: String,
) {
    AsyncImage(
        modifier = Modifier.clip(CircleShape),
        model = imageUrl,
        contentDescription = stringResource(R.string.tourist_photo),
    )
}