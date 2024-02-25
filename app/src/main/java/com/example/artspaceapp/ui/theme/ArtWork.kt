package com.example.artspaceapp.ui.theme

import android.media.Image
import androidx.compose.runtime.mutableStateOf
import com.example.artspaceapp.R

data class ArtWork(
    val imageId: Int,
    val title: String,
    val type: String,
    val loaction: String
)
 val currentIndex = mutableStateOf(0)

val artWorkList = listOf(
    ArtWork(
        imageId = R.drawable.delhi,
        title = "delhi",
        type = "city",
        loaction = "india"
    ),
            ArtWork(
            imageId = R.drawable.london,
    title = "london",
    type = "city",
    loaction = "europe"
),
    ArtWork(
        imageId = R.drawable.newyork,
        title = "newyork",
        type = "city",
        loaction = "usa"
    ),
    ArtWork(
        imageId = R.drawable.tokiyo,
        title = "tokiyo",
        type = "city",
        loaction = "japan"
    )
)