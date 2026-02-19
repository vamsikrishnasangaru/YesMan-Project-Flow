package com.yesman.autoride.data

import com.yesman.autoride.model.AutoBooking
import com.yesman.autoride.model.AutoRideOption

object FakeAutoRideRepository {
    val rideOptions = listOf(
        AutoRideOption("auto-lite", "Auto Lite", etaMinutes = 3, priceEstimate = 78, seats = 3, badge = "Lowest Fare"),
        AutoRideOption("auto-prime", "Auto Prime", etaMinutes = 2, priceEstimate = 95, seats = 3, badge = "Faster Pickup"),
        AutoRideOption("auto-share", "Auto Share", etaMinutes = 5, priceEstimate = 52, seats = 1, badge = "Save More")
    )

    fun activeBooking(): AutoBooking = AutoBooking(
        pickup = "Connaught Place, New Delhi",
        drop = "Karol Bagh Metro Gate 2",
        selectedOption = rideOptions[0],
        captainName = "Rakesh Kumar",
        captainRating = 4.8,
        vehicleNumber = "DL 1R AB 4582",
        otp = "4291",
        status = "Captain arriving in 2 mins"
    )
}
