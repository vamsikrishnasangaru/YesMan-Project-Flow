package com.yesman.autoride.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.yesman.autoride.data.FakeAutoRideRepository

@Composable
fun RideStatusScreen(onBackHome: () -> Unit) {
    val booking = FakeAutoRideRepository.activeBooking()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Ride in progress", style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold)
        Text(booking.status, color = MaterialTheme.colorScheme.secondary)

        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text("Captain: ${booking.captainName} (${booking.captainRating}★)")
                Text("Vehicle: ${booking.vehicleNumber}")
                Text("OTP: ${booking.otp}", fontWeight = FontWeight.Bold)
                Text("Route: ${booking.pickup} → ${booking.drop}")
            }
        }

        Button(onClick = onBackHome, modifier = Modifier.fillMaxWidth()) {
            Text("Back to Home")
        }
    }
}
