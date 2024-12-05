package com.example.index_human

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    private lateinit var bmiResult: TextView
    private lateinit var bmiImage: ImageView
    private lateinit var adviceText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        bmiResult = findViewById(R.id.bmiResult)
        bmiImage = findViewById(R.id.bmiImage)
        adviceText = findViewById(R.id.adviceText)

        val height = intent.getDoubleExtra("HEIGHT", 0.0) / 100
        val weight = intent.getDoubleExtra("WEIGHT", 0.0)

        val bmi = weight / (height * height)

        bmiResult.text = "Индекс массы тела: %.2f".format(bmi)

        when {
            bmi < 18.5 -> {
                bmiImage.setImageResource(R.drawable.underweight)
                adviceText.text = "Вы недостаточно весите. Рекомендуем проконсультироваться с врачом и следить за своим питанием."
            }
            bmi in 18.5..24.9 -> {
                bmiImage.setImageResource(R.drawable.ic_normal)
                adviceText.text = "Ваш вес в норме! Продолжайте следить за своим здоровьем и придерживаться сбалансированного питания."
            }
            bmi in 25.0..29.9 -> {
                bmiImage.setImageResource(R.drawable.ic_launcher_obesity)
                adviceText.text = "У вас избыточный вес. Рекомендуем следовать плану здорового питания и заниматься спортом."
            }
            else -> {
                bmiImage.setImageResource(R.drawable.ic_overweight)
                adviceText.text = "У вас ожирение. Пожалуйста, обратитесь к врачу для получения рекомендаций по улучшению здоровья."
            }
        }
    }
}