package com.example.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme
import com.example.artspaceapp.ui.theme.ArtWork
import com.example.artspaceapp.ui.theme.artWorkList
import com.example.artspaceapp.ui.theme.currentIndex

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceLayout(
                        artworkList = artWorkList,
                        currentIndex = currentIndex.value,
                        onNextClicked= { onNextClicked() },
                        onPreviousClicked = { onPreviousClicked() }
                    )

                }
            }
        }
    }
}

@Composable
fun ArtSpaceLayout(
    artworkList: List<ArtWork>,
    currentIndex: Int,
    onNextClicked: () -> Unit,
    onPreviousClicked: () -> Unit
){
    val currentArtwork = artworkList[currentIndex]
    
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .border(
                BorderStroke(1.dp, Color.Gray)
            )
    ) {
        Image(painter = painterResource(id = currentArtwork.imageId),
            contentDescription = "artwork image" ,
        modifier = Modifier
            .wrapContentSize()
            .size(300.dp)
        )
        Spacer(modifier = Modifier.height(64.dp))

        // Information about the artwork
        Column(
            modifier = Modifier.padding(vertical = 16.dp)

        ) {
            OutlinedCard(modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .align(CenterHorizontally),

            )
            {
                Column(modifier = Modifier.align(CenterHorizontally)) {

                    Text(
                        text = ("name. " + currentArtwork.title),
                        textAlign = TextAlign.Start
                    )
                    Text(
                        text = ("Type. " + currentArtwork.type),
                        textAlign = TextAlign.Start
                    )
                    Text(
                        text = ("Loacion. " + currentArtwork.loaction),
                        textAlign = TextAlign.Start
                    )
                }

            }
        }

        Spacer(modifier = Modifier.height(64.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Other elements (buttons)
            Button(
                onClick = { onPreviousClicked()},
                modifier = Modifier
                    .padding(8.dp)
                    .size(height = 50.dp, width = 100.dp)
            ) {
                Text(text = "Previous")
            }
            Button(
                onClick = { onNextClicked() },
                modifier = Modifier
                    .padding(8.dp)
                    .size(height = 50.dp, width = 100.dp)
            ) {
                Text(text = "Next")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewArtSpaceApp() {
    ArtSpaceAppTheme {
        ArtSpaceLayout(
            artworkList = artWorkList,
            currentIndex = currentIndex.value,
            onNextClicked= { onNextClicked() },
            onPreviousClicked = { onPreviousClicked() }
        )
    }
}

fun onNextClicked() {
    currentIndex.value = (currentIndex.value + 1) % artWorkList.size
}

fun onPreviousClicked() {
    currentIndex.value = (currentIndex.value - 1 + artWorkList.size) % artWorkList.size
}






