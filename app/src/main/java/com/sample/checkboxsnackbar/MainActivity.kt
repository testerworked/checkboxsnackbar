package com.sample.checkboxsnackbar

import android.content.DialogInterface
import android.os.Bundle
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

        val saveB = findViewById<Button>(R.id.saveB)
        saveB.setOnClickListener {
            saveData()
        }

        val deleteB = findViewById<Button>(R.id.deleteB)
        deleteB.setOnClickListener {
            deleteWidget()
        }
        
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun saveData() {
        val inputData = textET.text.toString()
        textResult.text = textResult.text.toString()+ "\n" + inputData
    }

    private fun deleteWidget() {
        val buildWidget = AlertDialog.Builder(this)
        buildWidget.setMessage("Подтвердите удаление")
            .setPositiveButton("Удалить", DialogInterface.OnClickListener { dialog, id ->
                textResult.text = ""
                Snackbar.make(findViewById(android.R.id.content), "Данные удалены", Snackbar.LENGTH_SHORT).show()
            })
            .setNegativeButton("Отмена", DialogInterface.OnClickListener { dialog, id ->
                dialog.dismiss()
            })
        buildWidget.create().show()
    }
}