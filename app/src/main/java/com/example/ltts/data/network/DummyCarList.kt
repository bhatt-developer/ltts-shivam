package com.example.ltts.data.network

import com.example.ltts.data.dto.model.CarModelDto
import javax.inject.Inject

class DummyCarList @Inject constructor() : CarApi {

    override suspend fun getCars(): List<CarModelDto> {
        return arrayListOf(
            CarModelDto(1,"TATA Nexon.ev","TATA","https://akm-img-a-in.tosshub.com/businesstoday/images/story/202301/tata_nexon_ev_max-sixteen_nine.jpg?size=948:533",
                "The Tata Nexon EV is one of two subcompact electric SUVs in India, and its only rival is the Mahindra XUV400. Priced between Rs 14.49 lakh and Rs 19.49 lakh (ex-showroom), the Nexon EV offers a modern design, upmarket cabin, great features, and enough range for you city commutes"),
            CarModelDto(2,"TATA Nexon.ev","TATA","https://images.hindustantimes.com/auto/img/2024/10/11/600x338/Harrier_EV_Front_Side_1673598047475_1728619659669.jpg",
                "The Tata Nexon EV is one of two subcompact electric SUVs in India, and its only rival is the Mahindra XUV400. Priced between Rs 14.49 lakh and Rs 19.49 lakh (ex-showroom), the Nexon EV offers a modern design, upmarket cabin, great features, and enough range for you city commutes."),
            CarModelDto(3,"HONDA city","HONDA","https://ackodrive.com/_next/image/?url=https%3A%2F%2Fackodrive-assets.ackodrive.com%2Fmedia%2Ftest_Cc9asJZ.jpeg&w=640&q=75","Engine: A 1.5L Atkinson Cycle DOHC i-VTEC engine and two-motor e-CVT traction motor \n" +
                    "Fuel efficiency: ARAI-claimed fuel efficiency of 26.5 kmpl \n" +
                    "Safety: 5-star safety rating and features like automatic emergency braking, adaptive cruise control, high beam assist, and lane keep assist \n" +
                    "Interior: An 8-inch touchscreen infotainment system with wireless Android Auto and Apple CarPlay, a sunroof, ambient lighting, and automatic climate control \n" +
                    "Warranty: 10-year anytime warranty and an 8-year warranty on the lithium ion battery \n" +
                    "Body: Honda-exclusive ACE™ Body Structure that absorbs and deflects collision energy"),
            CarModelDto(4,"TATA Nexon.ev","TATA","https://akm-img-a-in.tosshub.com/businesstoday/images/story/202301/tata_nexon_ev_max-sixteen_nine.jpg?size=948:533","The Tata Nexon EV is one of two subcompact electric SUVs in India, and its only rival is the Mahindra XUV400. Priced between Rs 14.49 lakh and Rs 19.49 lakh (ex-showroom), the Nexon EV offers a modern design, upmarket cabin, great features, and enough range for you city commutes."),
            CarModelDto(5,"TATA Nexon.ev","TATA","https://akm-img-a-in.tosshub.com/businesstoday/images/story/202301/tata_nexon_ev_max-sixteen_nine.jpg?size=948:533","The Tata Nexon EV is one of two subcompact electric SUVs in India, and its only rival is the Mahindra XUV400. Priced between Rs 14.49 lakh and Rs 19.49 lakh (ex-showroom), the Nexon EV offers a modern design, upmarket cabin, great features, and enough range for you city commutes."),
            CarModelDto(6,"TATA Nexon.ev","TATA","https://akm-img-a-in.tosshub.com/businesstoday/images/story/202301/tata_nexon_ev_max-sixteen_nine.jpg?size=948:533","The Tata Nexon EV is one of two subcompact electric SUVs in India, and its only rival is the Mahindra XUV400. Priced between Rs 14.49 lakh and Rs 19.49 lakh (ex-showroom), the Nexon EV offers a modern design, upmarket cabin, great features, and enough range for you city commutes."),
            CarModelDto(7,"TATA Nexon.ev","TATA","https://akm-img-a-in.tosshub.com/businesstoday/images/story/202301/tata_nexon_ev_max-sixteen_nine.jpg?size=948:533","The Tata Nexon EV is one of two subcompact electric SUVs in India, and its only rival is the Mahindra XUV400. Priced between Rs 14.49 lakh and Rs 19.49 lakh (ex-showroom), the Nexon EV offers a modern design, upmarket cabin, great features, and enough range for you city commutes."),
            CarModelDto(8,"TATA Nexon.ev","TATA","https://akm-img-a-in.tosshub.com/businesstoday/images/story/202301/tata_nexon_ev_max-sixteen_nine.jpg?size=948:533","The Tata Nexon EV is one of two subcompact electric SUVs in India, and its only rival is the Mahindra XUV400. Priced between Rs 14.49 lakh and Rs 19.49 lakh (ex-showroom), the Nexon EV offers a modern design, upmarket cabin, great features, and enough range for you city commutes."),
            CarModelDto(9,"TATA Nexon.ev","TATA","https://akm-img-a-in.tosshub.com/businesstoday/images/story/202301/tata_nexon_ev_max-sixteen_nine.jpg?size=948:533","The Tata Nexon EV is one of two subcompact electric SUVs in India, and its only rival is the Mahindra XUV400. Priced between Rs 14.49 lakh and Rs 19.49 lakh (ex-showroom), the Nexon EV offers a modern design, upmarket cabin, great features, and enough range for you city commutes."),
            CarModelDto(10,"TATA Nexon.ev","TATA","https://akm-img-a-in.tosshub.com/businesstoday/images/story/202301/tata_nexon_ev_max-sixteen_nine.jpg?size=948:533","The Tata Nexon EV is one of two subcompact electric SUVs in India, and its only rival is the Mahindra XUV400. Priced between Rs 14.49 lakh and Rs 19.49 lakh (ex-showroom), the Nexon EV offers a modern design, upmarket cabin, great features, and enough range for you city commutes.")
        )
    }

    override suspend fun getCarDetails(id: Int): CarModelDto {
        TODO("Not yet implemented")
    }

    override suspend fun updateCar(id: Int, carModelDto: CarModelDto): CarModelDto {
        TODO("Not yet implemented")
    }

}