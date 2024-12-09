package com.example.ltts.domain.use_case

import com.example.ltts.domain.repository.CarRepository
import javax.inject.Inject

class CarUseCase @Inject constructor(private val carRepository: CarRepository) {
    operator fun invoke() = carRepository.getCars()

     fun getCarDetails(number : Int) = carRepository.getCarDetail(number)

    fun updateBrand(id : Int ,brand: String, carName : String , desc : String)  = carRepository.updateBrand(id,brand,carName,desc)


}