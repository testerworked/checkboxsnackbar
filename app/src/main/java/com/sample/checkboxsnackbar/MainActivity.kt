package com.sample.checkboxsnackbar

import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var textET: EditText
    private lateinit var textResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        textET = findViewById(R.id.textET)
        textResult = findViewById(R.id.resultTV)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun saveData(view: View) {
        val inputData = textET.text.toString()
        textResult.text = textResult.text.toString()+ "\n" + inputData
        Snackbar
            .make(
                view,
                "Данные сохранены",
                Snackbar.LENGTH_LONG
            ).show()
    }

    fun checkDelete(view: View){
        Snackbar
            .make(
            view,
            "Подтвердите удаление",
            Snackbar.LENGTH_LONG
        ).setAction("Удалить") {
            textResult.text = ""
            Snackbar.make(
                view,
                "Данные удалены",
                Snackbar.LENGTH_LONG
            ).show()
        }.show()
    }

}