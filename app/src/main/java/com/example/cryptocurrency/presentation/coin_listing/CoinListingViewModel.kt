package com.example.cryptocurrency.presentation.coin_listing


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptocurrency.common.Response
import com.example.cryptocurrency.domain.usecases.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class CoinListingViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(CoinListingScreenState())
    var uiState:StateFlow<CoinListingScreenState> = _uiState.asStateFlow()

    init {
        getCoins()
    }

    private fun getCoins(){
        getCoinsUseCase().onEach {
            when(it){
                is Response.Loading -> {
                    _uiState.update { state ->
                        state.copy(isLoading = true)
                    }
                }
                is Response.Success -> {
                    var responseData = it.data
                    _uiState.update { state ->
                        state.copy(
                            coins = responseData.toMutableList(),
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

