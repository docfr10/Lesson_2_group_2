package com.example.lesson_2_group_2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

// Класс MainActivity, наследник класса AppCompatActivity
class MainActivity : AppCompatActivity() {
    // Метод onCreate
    override fun onCreate(savedInstanceState: Bundle?) {
        // Вызов родительского метода onCreate
        super.onCreate(savedInstanceState)
        // Игнорирование рамок телефона
        enableEdgeToEdge()
        // Опредялет то,как будет выглядеть экран приложения
        // Содержит ссылку на xml файл с разметкой
        setContentView(R.layout.activity_main)
        // Определение отступов экрана
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}