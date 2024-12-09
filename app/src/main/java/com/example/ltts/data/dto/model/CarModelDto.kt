package com.example.ltts.data.dto.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "tlls")
data class CarModelDto(
    @PrimaryKey(autoGenerate = true)
    val number: Int,
    val name: String,
    val brand: String,
    val imageUrl: String,
    val desc : String
) : Serializable