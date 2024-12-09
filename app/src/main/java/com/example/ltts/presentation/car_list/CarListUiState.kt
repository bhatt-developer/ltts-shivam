package com.example.ltts.presentation.car_list

import com.example.ltts.data.dto.model.CarModelDto
import com.example.ltts.domain.model.CarModel

/*data class UIState(
    val state : State = State.None,
    //val isLoading :Boolean = false,
    //val cars : List<CarModel> = emptyList(),
    //val error : String
    ){

    sealed class State{
        object None : State()
        object Loading : State()
        object Success : State()
        object Empty : State()
        object NoInternet : State()
        object Error : State()

    }
}*/

sealed class MainUiState{
    object Init : MainUiState()
    object Loading : MainUiState()
    data class Success(val cars : List<CarModelDto>) : MainUiState()
    data class Error(val error : String) : MainUiState()
}

sealed class CartDetailsUiState{
    object Init : CartDetailsUiState()
    object Loading : CartDetailsUiState()
    data class Success(val car : CarModelDto) : CartDetailsUiState()
    data class Error(val error: String) : CartDetailsUiState()

}
