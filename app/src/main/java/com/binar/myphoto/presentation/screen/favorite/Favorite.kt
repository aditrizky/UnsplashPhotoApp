package com.binar.myphoto.presentation.screen


import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.binar.myphoto.presentation.screen.favorite.FavoriteViewModel
import com.binar.myphoto.R
import com.binar.myphoto.presentation.FavoriteItem
import org.koin.androidx.compose.getViewModel

@Composable
fun FavoriteScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Favorite", color = Color.White, fontSize = 14.sp) },
                backgroundColor = colorResource(
                    id = R.color.blue
                )
            )
        },
        content = {FavoriteList(navController =navController )})

}


@Composable
fun FavoriteList(navController: NavHostController) {
    val viewModel = getViewModel<FavoriteViewModel>()
    viewModel.getAllFavorite()
    val photoResult = viewModel.getFavorite().observeAsState()
    photoResult.value?.let {
        LazyColumn(modifier = Modifier.padding(bottom = 56.5.dp)) {
            items(items = it) { item ->
                FavoriteItem(result = item, onItemClick = {
                    navController.navigate("detail_screen/${it.id}")
                })
            }
        }
    }
}

@Composable
@Preview
fun FavoriteScreenPreview() {

}