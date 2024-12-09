package com.example.ltts.data.network

import com.example.ltts.data.dto.model.CarModelDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

interface CarApi {

    //@GET("cars")
    suspend fun getCars(): List<CarModelDto>

    @GET("car/{id}")
    suspend fun getCarDetails(@Path("id") id: Int): CarModelDto

    @PUT("car/{id}")
    suspend fun updateCar(@Path("id") id: Int, @Body carModelDto: CarModelDto): CarModelDto

}
