package com.example.cryptocurrency.presentation.coin_details

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptocurrency.common.Response
import com.example.cryptocurrency.domain.usecases.GetCoinDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class CoinDetailsViewModel @Inject constructor(
    private val getCoinDetailUseCase: GetCoinDetailUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _uiState = MutableStateFlow(CoinDetailsScreenState())
    val uiState:StateFlow<CoinDetailsScreenState> = _uiState

    init {
        savedStateHandle.get<String>("coinId")?.let { coinId ->
            getCoinDetailUseCase(coinId).onEach {
                when(it){
                    is Response.Loading -> {
                        _uiState.update { state ->
                            state.copy(isLoading = true)
                        }
                    }
                    is Response.Success -> {
                        _uiState.update { state ->
                            state.copy(
                                coinDetail = it.data,
                                isLoading = false
                            )
                        }
                    }
                    is Response.Failure -> {
                        _uiState.update { state ->
                            state.copy(
                                error = it.message,
                                isLoading = false
                            )
                        }
                    }
                }
            }.launchIn(viewModelScope)
        }
    }
}