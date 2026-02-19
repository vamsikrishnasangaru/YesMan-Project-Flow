package com.yesman.autoride.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.yesman.autoride.data.FakeAutoRideRepository

@Composable
fun BookRideScreen(onConfirmRide: () -> Unit) {
    val pickup = remember { mutableStateOf("Connaught Place") }
    val drop = remember { mutableStateOf("Karol Bagh") }
    val selectedOption = remember { mutableStateOf(FakeAutoRideRepository.rideOptions.first()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Book your auto", style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold)

        OutlinedTextField(
            value = pickup.value,
            onValueChange = { pickup.value = it },
            label = { Text("Pickup") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = drop.value,
            onValueChange = { drop.value = it },
            label = { Text("Drop") },
            modifier = Modifier.fillMaxWidth()
        )

        Text("Choose ride", fontWeight = FontWeight.SemiBold)
        FakeAutoRideRepository.rideOptions.forEach { option ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { selectedOption.value = option },
                shape = RoundedCornerShape(14.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(14.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text(option.name, fontWeight = FontWeight.Bold)
                        Text("${option.etaMinutes} mins • ${option.seats} seat(s)")
                        Text(option.badge)
                    }
                    Text("₹${option.priceEstimate}", style = MaterialTheme.typography.titleMedium)
                }
            }
        }

        Text("Selected: ${selectedOption.value.name}", color = MaterialTheme.colorScheme.secondary)
        Button(onClick = onConfirmRide, modifier = Modifier.fillMaxWidth()) {
            Text("Confirm Auto • ₹${selectedOption.value.priceEstimate}")
        }
    }
}
