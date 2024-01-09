package com.example.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun NextVideo(videoTitle: String, views: Int, timeAgo: String, modifier: Modifier = Modifier) {
     Column (modifier = modifier.fillMaxWidth()) {
        Image(

                    painter = painterResource (id = R.drawable.berry),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                    .fillMaxWidth()
                .aspectRatio ( 16f / 9f)
        )
        Spacer(modifier = Modifier.height(12.dp))
        NextVideo(
            videoTitle = videoTitle,
            views = views,
            timeAgo = timeAgo,
            modifier = Modifier.padding(horizontal = 12.dp))
     }}