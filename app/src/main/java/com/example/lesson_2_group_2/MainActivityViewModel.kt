package com.example.lesson_2_group_2

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lesson_2_group_2.databinding.ActivityMainBinding

// Класс MainActivityViewModel, наследник системного класса ViewModel
// Имеет доступ к жизненному циклу ViewModel
class MainActivityViewModel : ViewModel() {
    // Тип данных MutableLiveData
    private val editText = MutableLiveData<String>()

    fun getEditText(): MutableLiveData<String> = editText

    // Метод считывания значения Switch
    fun switch(activityMainBinding: ActivityMainBinding) {
        if (activityMainBinding.switch1.isChecked) {
            activityMainBinding.switch1.isChecked = true
            activityMainBinding.switch1.text = "Включено"
        } else {
            activityMainBinding.switch1.isChecked = false
            activityMainBinding.switch1.text = "Выключено"
        }
    }
}