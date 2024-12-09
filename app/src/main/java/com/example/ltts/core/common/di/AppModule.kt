package com.example.ltts.core.common.di

import android.content.Context
import androidx.room.Room
import com.example.ltts.core.common.Constants
import com.example.ltts.core.common.db.LttsDao
import com.example.ltts.core.common.db.LttsDatabase
import com.example.ltts.data.network.CarApi
import com.example.ltts.data.network.DummyCarList
import com.example.ltts.data.repository.CarRepositoryImpl
import com.example.ltts.domain.repository.CarRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)


object AppModule {

    @Singleton
    @Provides
    fun provideRetrofitInstance() : Retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL)
            .build()


  /*  @Singleton
    @Provides
    fun providesCarApiInstance(retrofit: Retrofit): CarApi{
        return create(CarApi::class.java)
    }*/

    @Singleton
    @Provides
    fun providesCarRepository(carApi: CarApi, lttsDatabase: LttsDatabase ): CarRepository{
        return CarRepositoryImpl(carApi, lttsDatabase)
    }

    @Singleton
    @Provides
    fun providesDummyCarList(): CarApi{
        return DummyCarList()
    }

    @Provides
    @Singleton
    fun providesLttsDatabaseInstance(@ApplicationContext context: Context) : LttsDatabase{
     return Room.databaseBuilder(context,LttsDatabase::class.java,"ltts_db").build()
    }



}