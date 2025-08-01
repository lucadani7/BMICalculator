# BMICalculator
It's a simple Android app who calculates your BMI (Body Mass Index), realised in Kotlin programming language, using Jetpack Compose. It is not indented to replace existing websites who do the same thing (such as https://www.calculator.net/bmi-calculator.html). This app was created for educational purposes. 

---
## Why Jetpack Compose?
Once upon a time, when Jetpack Compose didn't even exist, the Android devs used to write a separate XML file (activity_main.xml), who had to be synchronized with main Kotlin file (MainActivity.kt). So they had to fight against LinearLayout, ConstraintLayout, TextView, marginTop="16dp" and android:id="@+id/buton". If you were writing something wrong in the XML file, Android Studio IDE wasn't hesitating to complain: “Render problem”, “Missing constraint”, “Unresolved symbol” etc. With Jetpack Compose, that XML file is no longer needed.

---
## 🛠️ Tech Stack
- Kotlin
- Android Studio
- Jetpack Compose
- Material 3

---
## 🛠 Requirements
- Android Studio IDE installed locally (if you don't have it, download from here: https://developer.android.com/studio)

---
## 💻 How to Run
1. Open Android Studio and select "Check out project from Version Control" from the Welcome screen. If a project is already open, go to File > New > Project from Version Control > Git.
2. Enter Repository URL: In the URL field, paste the URL of this GitHub repository: https://github.com/lucadani7/BMICalculator.git
3. Clone: Click "Clone". Android Studio will clone the repository to your local machine and open it.
4. Run the project on the emulator or on a real Android device.

---
## 🚀 Features
- Typing your weight (in km) and your height (in cm)
- Calculating BMI according to the stardard formula: your_BMI = your_weight / (your_height_in_metres ^ 2), knowing that 1 m = 100 cm
- Displaying BMI category: underweight, normal, overweight, obese
- Validating typed data

---

## 🛰️ License

Apache-2.0

---

## 🧑‍🚀 Author

Luca Daniel Ionescu  
[GitHub Profile](https://github.com/lucadani7)
