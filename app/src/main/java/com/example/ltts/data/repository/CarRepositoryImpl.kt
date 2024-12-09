package com.example.ltts.data.repository


import com.example.ltts.core.common.Resource
import com.example.ltts.core.common.db.LttsDatabase
import com.example.ltts.data.dto.model.CarModelDto
import com.example.ltts.data.network.CarApi
import com.example.ltts.domain.repository.CarRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

class CarRepositoryImpl @Inject constructor(private val carApi: CarApi, private val lttsDatabase: LttsDatabase) : CarRepository {

    override fun getCars(): Flow<Resource<List<CarModelDto>>> = flow {

        emit(Resource.Loading())

        val apiCarListResult = carApi.getCars().map {
            lttsDatabase.getLttsDao().insert(it)
            it
        }

        emit(Resource.Success(apiCarListResult))

    }.flowOn(Dispatchers.IO)
        .catch {
            emit(Resource.Error(it.toString().toString()))
        }

    override  fun getCarDetail(number: Int): Flow<CarModelDto> =
      lttsDatabase.getLttsDao().selectCar(number)

      override fun updateBrand(number: Int, brand: String, name : String , desc: String){
          CoroutineScope(Dispatchers.IO).launch {
              lttsDatabase.getLttsDao().updateBrand(number,brand , name,desc)

          }
      }

}