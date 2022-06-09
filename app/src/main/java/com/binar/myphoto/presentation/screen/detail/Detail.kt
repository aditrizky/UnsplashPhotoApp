package com.binar.myphoto.presentation.screen


import android.R
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import coil.size.Scale
import com.binar.myphoto.presentation.screen.detail.DetailViewModel
import com.binar.myphoto.data.local.Favorite.PhotoFavorite

import org.koin.androidx.compose.getViewModel

@OptIn(ExperimentalCoilApi::class)
@Composable
fun DetailScreen(photoId: String? = null) {
    val viewModel = getViewModel<DetailViewModel>()
    viewModel.getDetail(photoId.toString())
    val result = viewModel.detailPhoto().observeAsState()
    val contex = LocalContext.current
    result.value?.let {
        val photoFavorite= PhotoFavorite(
            id = it.id,
            description = it.description,
            createdAt = it.createdAt,
            urls = it.urls?.regular,
            likes = it.likes
        )
        Column {
            Image(
                painter = rememberImagePainter(data = it.urls?.regular,
                    builder = {
                        scale(Scale.FILL)
                        placeholder(R.drawable.ic_popup_sync)
                    }),
                contentDescription = it.id,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(500.dp)

            )
            Row(modifier = Modifier.wrapContentWidth()) {
                Text(
                    text = it.likes.toString() + " likes",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(top = 2.dp, start = 8.dp)
                )
                val image = painterResource(id = R.drawable.ic_input_get)
                Spacer(modifier = Modifier.padding(start = 280.dp))
                Image(
                    painter = image,
                    contentDescription = "save",
                    modifier = Modifier
                        .clickable {
                            viewModel.addFavorite(photoFavorite)
                            Toast.makeText(contex,"Success Add To Favorite",Toast.LENGTH_SHORT).show()
                        }
                        .size(40.dp)

                )

            }
            Spacer(modifier = Modifier.padding(top = 4.dp))
            Text(
                text = "Created At : " + it.createdAt.toString(), modifier = Modifier
                    .padding(start = 8.dp, top = 4.dp),
                fontSize = 12.sp

            )
            if (it.description.toString() != "null") {
                Text(
                    text = it.description.toString(),
                    modifier = Modifier
                        .padding(start = 8.dp, top = 2.dp)
                )
            }


        }


    }

}

@Composable
@Preview
fun SettingsScreenPreview() {
    DetailScreen("")
}
