package com.example.lesson_2_group_2

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lesson_2_group_2.databinding.ActivityMainBinding

// Класс MainActivity, наследник класса AppCompatActivity
class MainActivity : AppCompatActivity() {
    // Свойство, хранящее значение того было ли показано информационное сообщение пользователю
    private var toast: Boolean = false

    // Метод, который будет запущен при нажатии на кнопку через xml параметр onClick
    fun clickButton2(v: View) {
        Toast.makeText(this, "Кнопка нажата через параметр onClick", Toast.LENGTH_SHORT).show()
    }

    // Свойство с поздней инициализацией для использования библиотеки viewBinding
    private lateinit var activityMainBinding: ActivityMainBinding

    // Метод onCreate - запускается самым первым при старте активности, либо после вызова onPause
    // Создает объекты пользовательского интерфейса перед показом пользователю
    override fun onCreate(savedInstanceState: Bundle?) {
        // Вызов родительского метода onCreate
        super.onCreate(savedInstanceState)

        // Инициализация свойства binding
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)

        // Присвоение свойству toast значения из Bundle хранилища с ключом TOAST
        if (savedInstanceState != null)
            toast = savedInstanceState.getBoolean("TOAST")

        // Игнорирование рамок телефона
        enableEdgeToEdge()

        // Опредялет то,как будет выглядеть экран активности
        // Содержит ссылку на xml файл с разметкой
        // setContentView(R.layout.activity_main)

        // Аналогичная ссылка на макет пользовательского интерфейса с библиотекой viewBinding
        setContentView(activityMainBinding.root)

        // Определение отступов экрана
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Информационный лог
        Log.i("Метод жизненного цикла", "Метод onCreate запущен")

        // Проверка того было ли показано пользователю информационное сообщение
        if (!toast) {
            // Всплываюшее сообщение, которое увидит пользователь
            Toast.makeText(this, "Привет пользователь", Toast.LENGTH_SHORT).show()
            toast = true
        }

        // Создание объектов пользовательского интерфейса
        val textView: TextView = findViewById(R.id.textView)
        val textView2: TextView = findViewById(R.id.textView2)
        val button = findViewById<Button>(R.id.button)
        val imageView = findViewById<ImageView>(R.id.imageView)

        // Работа с элементами пользовательского интерфейса в коде
        // Замена текста в TextView
        textView.text = getString(R.string.app_name)
        textView2.setText("Again new text")

        // Замена текста в Button
        button.text = "Click!"

        // Слушатель нажатий в Button
        button.setOnClickListener {
            Toast.makeText(this, "Кнопка нажата!", Toast.LENGTH_SHORT).show()
            button.text = "Button"
        }

        // Слушатель нажатий, который реагирует на долгое нажатие
        button.setOnLongClickListener {
            button.text = "Long click!"
            return@setOnLongClickListener true
        }

        // Смена изображения в ImageView
        imageView.setImageResource(R.drawable.ic_launcher_background)

        // Использование объекта activityMainBinding
        // Обработка введеного в EditText текста
        Log.i("EDIT_TEXT", activityMainBinding.editTextText.text.toString())
        // Смена текста в EditText
        activityMainBinding.editTextPhone.setText("1234")

        // Работа со Switch
        activityMainBinding.switch1.setOnClickListener {
            if (activityMainBinding.switch1.isChecked) {
                activityMainBinding.switch1.isChecked = true
                activityMainBinding.switch1.text = "Включено"
            } else {
                activityMainBinding.switch1.isChecked = false
                activityMainBinding.switch1.text = "Выключено"
            }
        }

        // Работа со Spinner
        // Создание адаптера, который будет содержать список, содержащийся в Spinner
        val spinnerAdapter = ArrayAdapter(
            this,
            androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
            listOf(
                "Kotlin",
                "Java",
                "Python",
                "PHP"
            )
        )
        // Загрузка созданного адаптера в Spinner
        activityMainBinding.spinner.adapter = spinnerAdapter
    }

    // Метод onStart - запускается после onCreate
    // Подготовливает пользовательский интерфейс к показу пользователю
    override fun onStart() {
        super.onStart()

        // Лог об ошибках
        Log.e("Метод жизненного цикла", "Метод onStart запущен")
    }

    // Метод onResume - запускается после onStart, либо после onPause
    // Демонстрирует пользователю интерфейс активности
    // После его вызова пользователь может взаимодействовать с интерфейсом
    override fun onResume() {
        super.onResume()

        // Лог о предупреждении
        Log.w("Метод жизненного цикла", "Метод onResume запущен")
    }

    // Метод onPause - запускается после onResume
    // Готовит активность к переходу в "спящий режим", возобновлению работы или перезагрузке
    override fun onPause() {
        super.onPause()

        // Лог о дебаге
        Log.d("Метод жизненного цикла", "Метод onPause запущен")
    }

    // Метод onStop - запускается после onPause
    // Переводит активность в "спящий режим" и готовит возобновлению работы или уничтожению
    override fun onStop() {
        super.onStop()

        // Лог со сторонней информацией
        Log.v("Метод жизненного цикла", "Метод onStop запущен")
    }

    // Метод onRestart - запускается после onStop
    // Перезагружает пользовательский интерфейс, но не создает его заново
    override fun onRestart() {
        super.onRestart()

        // Информационный лог
        Log.i("Метод жизненного цикла", "Метод onRestart запущен")
    }

    // Метод onDestroy - запускается после onStop
    // Вызывается перед уничтожением активности после ее заверршения работы
    override fun onDestroy() {
        super.onDestroy()

        // Информационный лог
        Log.i("Метод жизненного цикла", "Метод onDestroy запущен")
    }

    // Метод onSaveInstanceState - вызывается для записи значений в Bundle хранилище перед перезагрузкой активности
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        // Запись значения свойства toast в Bundle хранилище
        outState.putBoolean("TOAST", toast)
    }
}