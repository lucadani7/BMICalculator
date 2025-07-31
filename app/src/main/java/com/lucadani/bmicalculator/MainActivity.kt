package com.lucadani.bmicalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BMICalculatorScreen()
        }
    }
}

@Composable
fun BMICalculatorScreen() {
    var weight by remember { mutableStateOf("") }
    var height by remember { mutableStateOf("") }
    var bmi by remember { mutableStateOf<Double?>(null) }
    var errorMessage by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = weight,
            onValueChange = { weight = it },
            label = { Text("Weight (kg)") }
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = height,
            onValueChange = { height = it },
            label = { Text("Height (cm)") }
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = {
            bmi = calculateBMI(weight.toDoubleOrNull(), height.toDoubleOrNull())
            errorMessage = if (bmi != null) "" else "Invalid data. Check out again the weight and the height!"
        }) {
            Text("Calculate")
        }

        Spacer(modifier = Modifier.height(24.dp))

        if (errorMessage.isNotBlank()) {
            Text(errorMessage, color = MaterialTheme.colorScheme.error)
        } else if (bmi != null) {
            Text("BMI: %.2f".format(bmi))
            Text("Category: ${bmiCategory(bmi!!)}")
        }
    }
}

fun bmiCategory(bmi: Double): String = when {
    bmi < 18.5 -> "Underweight"
    bmi < 25 -> "Normal"
    bmi < 30 -> "Overweight"
    else -> "Obese"
}

fun calculateBMI(weight: Double?, height: Double?): Double? {
    if (weight == null || height == null || height <= 0) {
        return null
    }
    val heightInMetres: Double = height / 100
    return weight / (heightInMetres * heightInMetres)
}