package com.example.ltts.data.dto.mapper

import com.example.ltts.data.dto.model.CarModelDto
import com.example.ltts.domain.model.CarModel

fun CarModelDto.toDomainCarModel(): CarModel{
    return CarModel(number,name, imageUrl)
}
//TODO : Above extension function Explain SOLID Principle O --  Open for Extension* and close for Modification*