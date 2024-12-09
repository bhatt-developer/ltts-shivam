package com.example.ltts.domain.repository

import com.example.ltts.core.common.Resource
import com.example.ltts.data.dto.model.CarModelDto
import com.example.ltts.domain.model.CarModel
import kotlinx.coroutines.flow.Flow

interface CarRepository {
    fun getCars() : Flow<Resource<List<CarModelDto>>>

    fun getCarDetail(number : Int) : Flow<CarModelDto>

     fun updateBrand(number: Int,brand: String, carName: String ,desc : String)
}