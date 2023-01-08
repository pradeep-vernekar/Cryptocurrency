package com.example.cryptocurrency.presentation.coin_details

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.cryptocurrency.domain.entities.Team
import com.example.cryptocurrency.presentation.coin_details.composables.CoinTag
import com.example.cryptocurrency.presentation.coin_details.composables.TeamListItem
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun CoinDetailsScreen(
    viewModel:CoinDetailsViewModel = hiltViewModel()
){
    val state = viewModel.uiState.collectAsState()
    Box(modifier = Modifier.fillMaxSize()) {
        state.value.coinDetail?.let {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(20.dp)
            ){
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "${it.rank}. ${it.name} (${it.symbol})",
                            style = MaterialTheme.typography.h5,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier.weight(8.0f)
                        )
                        Text(
                            text = if(it.isActive == true)"active" else "inactive",
                            color = if(it?.isActive == true) Color.Green else Color.Red,
                            fontStyle = FontStyle.Italic,
                            textAlign = TextAlign.End,
                            style = MaterialTheme.typography.body2,
                            modifier = Modifier.align(Alignment.CenterVertically)
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = it.description ?: "",
                        style = MaterialTheme.typography.body2
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Tags",
                        style = MaterialTheme.typography.h6
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    FlowRow(
                        mainAxisSpacing = 10.dp,
                        crossAxisSpacing = 10.dp,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        it.tags?.forEach { tag ->
                            CoinTag(tag = tag?.name ?: "")
                        }
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Team Members",
                        style = MaterialTheme.typography.h6
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                }

               items(items = it.team ?: emptyList()){ teamMember ->
                    TeamListItem(
                        teamMember = teamMember,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                    )
                   Divider()
               }
            }

        }

        if (state.value.error.isNotEmpty()){
            Text(
                text = state.value.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }

        if(state.value.isLoading){
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}