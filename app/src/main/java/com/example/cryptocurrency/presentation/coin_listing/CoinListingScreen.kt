package com.example.cryptocurrency.presentation.coin_listing

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.cryptocurrency.presentation.coin_listing.composables.CoinListItem
import com.example.cryptocurrency.presentation.utils.Screen

@Composable
fun CoinListingScreen(
    viewModel:CoinListingViewModel = hiltViewModel(),
    navController: NavController
){
    val viewState = viewModel.uiState.collectAsState()
       Box(modifier = Modifier.fillMaxSize()) {
           LazyColumn(modifier = Modifier.fillMaxSize()){
               items(items = viewState.value.coins){ coin ->
                   CoinListItem(
                       coin = coin,
                       onItemClick = {
                           navController.navigate(
                               route = Screen.CoinDetailScreen.route+"?coinId=${it.id}"
                           )
                   })
               }
           }

           if (viewState.value.error.isNotEmpty()){
               Text(
                   text = viewState.value.error,
                   color = MaterialTheme.colors.error,
                   textAlign = TextAlign.Center,
                   modifier = Modifier
                       .fillMaxWidth()
                       .padding(horizontal = 20.dp)
                       .align(Alignment.Center)
               )
           }

           if(viewState.value.isLoading){
               CircularProgressIndicator(
                   modifier = Modifier.align(Alignment.Center)
               )
           }
       }
}