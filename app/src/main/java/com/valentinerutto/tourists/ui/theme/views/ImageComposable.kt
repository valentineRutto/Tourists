package com.valentinerutto.tourists.ui.theme.views

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.valentinerutto.tourists.R

@Composable
fun ImageComposable(
    imageUrl: String,
) {
    AsyncImage(
        modifier = Modifier.clip(CircleShape),
        model = imageUrl ,
        contentDescription = stringResource(R.string.tourist_photo),
    )
}
@Composable
fun image(    imageUrl: String,
){
    val painter = rememberAsyncImagePainter(imageUrl)
    val state = painter.state
    val transition by animateFloatAsState(
        targetValue = if (state is AsyncImagePainter.State.Success) 1f else 0f
    )
    if (state is AsyncImagePainter.State.Loading) {
        LoadingAnimation()
    }

    Image(
        painter = painter,
        contentDescription = "custom transition based on painter state",
        modifier = Modifier.alpha(transition)
    )

}
@Composable
fun LoadingAnimation() {
    val animation = rememberInfiniteTransition()
    val progress by animation.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000),
            repeatMode = RepeatMode.Restart,
        )
    )

    Box(
        modifier = Modifier
            .scale(progress)
            .alpha(1f - progress)


            .border(
                5.dp,
                color = Color.Black,
                shape = CircleShape
            )
    )
}

