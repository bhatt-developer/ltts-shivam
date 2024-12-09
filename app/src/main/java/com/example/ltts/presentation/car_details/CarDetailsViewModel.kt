package com.example.ltts.presentation.car_details

import android.text.TextUtils
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ltts.domain.use_case.CarUseCase
import com.example.ltts.presentation.car_list.CartDetailsUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CarDetailsViewModel @Inject constructor(val useCase: CarUseCase) : ViewModel() {

    private val _state = MutableStateFlow<CartDetailsUiState>(CartDetailsUiState.Init)
    val state: StateFlow<CartDetailsUiState> get() = _state

    fun getCarDetails(number: Int) {
        useCase.getCarDetails(number).onEach {

            _state.value = CartDetailsUiState.Success(it)

        }.launchIn(viewModelScope)
    }



    fun brandNameValidateCredentials(brandName: String,carName : String,desc : String): Pair<Boolean, String>{
        var result = Pair(true, "")
        if (TextUtils.isEmpty(brandName)){
            result = Pair(false, "Please provide the car brand")
        }else if (TextUtils.isEmpty(carName)){
            result = Pair(false, "Please provide the car name")
        }else if(TextUtils.isEmpty(desc)){
            result = Pair(false , "Please provide the description")
        }
        return result
    }

    fun updateBrand(number: Int,brand: String , carName: String, desc: String) {
        viewModelScope.launch {
            useCase.updateBrand(number, brand, carName , desc)
        }


    }
}