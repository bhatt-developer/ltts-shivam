package com.example.ltts.core.common.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.ltts.data.dto.model.CarModelDto
import kotlinx.coroutines.flow.Flow

@Dao
interface LttsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(carModelDto: CarModelDto) :Long

    @Query("SELECT * FROM TLLS WHERE number = :id")
     fun selectCar(id : Int) : Flow<CarModelDto>

    @Query("UPDATE tlls SET brand =:brandname, name = :carName, 'desc' = :descrp   WHERE number = :id")
    suspend fun updateBrand(id : Int, brandname : String, carName : String ,  descrp : String)
}
//,  desc : String