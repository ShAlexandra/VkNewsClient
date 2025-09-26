package com.example.vknewsclient.ui.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vknewsclient.R

@Composable
fun PostCard() {
    Box(
        modifier = Modifier
//            .background(MaterialTheme.colorScheme.onPrimary)
            .fillMaxWidth()
            .border(border = BorderStroke(width = 1.dp, color = MaterialTheme.colorScheme.outline))
            .padding(8.dp)
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row {
                    Image(
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape),
                        painter = painterResource(id = R.drawable.post_comunity_thumbnail),
                        contentDescription = null
                    )
                    Column(
                        modifier = Modifier.padding(start = 8.dp)
                    ) {
                        Text("уволено", color = MaterialTheme.colorScheme.onBackground)
                        Text("14.00", color = MaterialTheme.colorScheme.outline)
                    }
                }
                Icon(
                    imageVector = Icons.Rounded.MoreVert,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.outline
                )
            }
            Text(
                "Текст после хотя бы на пару строк для примера",
                modifier = Modifier.padding(vertical = 8.dp),
                color = MaterialTheme.colorScheme.onBackground
            )
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                painter = painterResource(id = R.drawable.post_content_image),
                contentScale = ContentScale.FillWidth,
                contentDescription = null
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row {
                    Text(
                        "206",
                        color = MaterialTheme.colorScheme.outline,
                        modifier = Modifier.padding(horizontal = 4.dp)
                    )
                    Image(
                        modifier = Modifier
                            .size(20.dp)
                            .clip(CircleShape),
                        painter = painterResource(id = R.drawable.ic_views_count),
                        contentDescription = null
                    )
                }
                Row {
                    Text(
                        "206",
                        color = MaterialTheme.colorScheme.outline,
                        modifier = Modifier.padding(horizontal = 4.dp)
                    )
                    Image(
                        modifier = Modifier
                            .size(20.dp),
                        painter = painterResource(id = R.drawable.ic_share),
                        contentDescription = null
                    )
                    Text(
                        "206",
                        color = MaterialTheme.colorScheme.outline,
                        modifier = Modifier.padding(horizontal = 4.dp)
                    )
                    Image(
                        modifier = Modifier
                            .size(20.dp),
                        painter = painterResource(id = R.drawable.ic_comment),
                        contentDescription = null
                    )
                    Text(
                        "206",
                        color = MaterialTheme.colorScheme.outline,
                        modifier = Modifier.padding(horizontal = 4.dp)
                    )
                    Image(
                        modifier = Modifier
                            .size(20.dp),
                        painter = painterResource(id = R.drawable.ic_like),
                        contentDescription = null
                    )
                }
            }
        }

    }
}

@Preview(showSystemUi = false, showBackground = true)
@Composable
private fun PreviewLight() {
    VkNewsClientTheme(darkTheme = false) {
        PostCard()
    }
}

@Preview()
@Composable
private fun PreviewDark() {
    VkNewsClientTheme(darkTheme = true) {
        PostCard()
    }
}