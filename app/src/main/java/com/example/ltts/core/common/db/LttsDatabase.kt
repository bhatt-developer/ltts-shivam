package com.example.ltts.core.common.db

import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RenameTable
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.AutoMigrationSpec
import com.example.ltts.data.dto.model.CarModelDto

@Database(entities = [CarModelDto::class], version = 1 )
abstract class LttsDatabase  : RoomDatabase() {

 abstract fun getLttsDao() : LttsDao

 companion object{

         @Volatile
        private var instance : LttsDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context)  = instance ?: synchronized(LOCK){
         instance ?: createDatabase(context).also { instance = it}
        }

private fun createDatabase(context: Context) =
Room.databaseBuilder(context.applicationContext,LttsDatabase::class.java,"ltts_db").build()

    }


}

/*
autoMigrations = [AutoMigration(from = 1 ,to= 2 , spec = LttsDatabase.MyAutoMigration::class)]
@RenameTable(fromTableName = "tlls", toTableName = "ltts")
class MyAutoMigration : AutoMigrationSpec*/
