package com.binar.myphoto.presentation.screen


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.binar.myphoto.presentation.screen.home.HomeViewModel
import com.binar.myphoto.presentation.PhotoItem
import com.binar.myphoto.presentation.SearchView
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeScreen(navController: NavHostController) {
    Scaffold() {
        val textState = remember { mutableStateOf(TextFieldValue("")) }
        Column() {
            SearchView(textValue = textState, navController)
            PhotoList(navController = navController)

        }

    }


}

@Composable
fun PhotoList(navController: NavHostController) {
    val viewModel = getViewModel<HomeViewModel>()
    val photoResult = viewModel.listPhoto().observeAsState()
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
