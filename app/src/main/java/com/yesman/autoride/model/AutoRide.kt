package com.yesman.autoride.model

data class AutoRideOption(
    val id: String,
    val name: String,
    val etaMinutes: Int,
    val priceEstimate: Int,
    val seats: Int,
    val badge: String
)

data class AutoBooking(
    val pickup: String,
    val drop: String,
    val selectedOption: AutoRideOption,
    val captainName: String,
    val captainRating: Double,
    val vehicleNumber: String,
    val otp: String,
    val status: String
)
