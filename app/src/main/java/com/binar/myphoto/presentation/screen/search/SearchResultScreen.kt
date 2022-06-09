package com.binar.myphoto.presentation.screen

import android.util.Log
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
import com.binar.myphoto.R
import com.binar.myphoto.presentation.screen.search.SearchViewModel
import com.binar.myphoto.presentation.PhotoItem
import org.koin.androidx.compose.getViewModel

@Composable
fun SearchResultScreen(navController: NavHostController,text:String?=null) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Search Result for : $text ", color = Color.White, fontSize = 14.sp) },
                backgroundColor = colorResource(
                    id = R.color.blue
                )
            )
        },
        content = {
            val viewModel = getViewModel<SearchViewModel>()
            val photoResult = viewModel.searchResult().observeAsState()
            Log.d("sc", photoResult.value.toString())
            photoResult.value?.let {
                LazyColumn(modifier = Modifier.padding(bottom = 56.5.dp)) {
                    items(items = it) { item ->
                        PhotoItem(result = item, onItemClick = {
                            navController.navigate("detail_screen/${it.id}")
                        })
                    }
                }
            }
        }
    )


}


@Composable
@Preview
fun SearchResultScreenPreview() {

}