package com.yesman.autoride.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.yesman.autoride.ui.theme.BrandYellow

@Composable
fun HomeScreen(onBookNow: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8F8F8))
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        Text("AutoRaid", style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold)
        Text("Book auto rides in seconds", style = MaterialTheme.typography.bodyLarge)

        Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(20.dp)) {
            Column(
                modifier = Modifier
                    .background(BrandYellow)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text("Daily Pass", fontWeight = FontWeight.Bold)
                Text("Get 20% off on first 5 rides")
                Button(onClick = onBookNow) {
                    Text("Book an Auto")
                }
            }
        }

        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                Text("Popular routes", fontWeight = FontWeight.SemiBold)
                RouteRow("India Gate", "Rajiv Chowk", "₹85")
                RouteRow("Lajpat Nagar", "Nehru Place", "₹65")
                RouteRow("Airport T1", "Dwarka Sector 21", "₹110")
            }
        }
        Spacer(Modifier.height(8.dp))
        Text("Safety: Verified captains, OTP boarding and live tracking.")
    }
}

@Composable
private fun RouteRow(from: String, to: String, fare: String) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Text("$from → $to")
        Text(fare, fontWeight = FontWeight.Medium)
    }
}
