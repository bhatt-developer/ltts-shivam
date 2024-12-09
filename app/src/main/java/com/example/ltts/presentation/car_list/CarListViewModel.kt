package com.example.ltts.presentation.car_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ltts.core.common.Resource
import com.example.ltts.domain.use_case.CarUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CarListViewModel @Inject constructor(private val carUseCase: CarUseCase) : ViewModel() {
    private val _uiStateFlow = MutableStateFlow<MainUiState>(MainUiState.Init)
    val uiStateFlow :  StateFlow<MainUiState> = _uiStateFlow


    init {
        getCars()
    }

    private fun getCars() {
          _uiStateFlow.value = MainUiState.Loading
        carUseCase().onEach {
            when(it){
                is Resource.Error -> {
                    _uiStateFlow.value =  MainUiState.Error(it.msg.toString())
                }
                is Resource.Loading -> {
                    _uiStateFlow.value = MainUiState.Loading
                }
                is Resource.Success -> {
                     _uiStateFlow.value = MainUiState.Success(it.data ?: emptyList())
                }
            }
        }.launchIn(viewModelScope)

    }
}