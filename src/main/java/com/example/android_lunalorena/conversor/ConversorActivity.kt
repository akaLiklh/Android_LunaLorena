package com.example.android_lunalorena.conversor

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.android_lunalorena.R

class ConversorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_conversor)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        findViewById<ImageButton>(R.id.atrasButton4).setOnClickListener { finish() }

        val etCantidad = findViewById<EditText>(R.id.editTextNumberDecimal)
        val cbDolar = findViewById<CheckBox>(R.id.checkBoxDolar)
        val cbLibra = findViewById<CheckBox>(R.id.checkBoxLibra)
        val cbYen = findViewById<CheckBox>(R.id.checkBoxYen)
        val btnConvertir = findViewById<Button>(R.id.btnConvertir)
        val tvResultado = findViewById<TextView>(R.id.txtResultado)
        val btnBorrar = findViewById<Button>(R.id.btnBorrar)

        btnConvertir.setOnClickListener {
            val euros = etCantidad.text.toString().replace(',', '.').toDoubleOrNull()

            if (euros == null) {
                tvResultado.text = "Porfaplis, introduce una cantidad"
            } else if (!cbDolar.isChecked && !cbLibra.isChecked && !cbYen.isChecked) {
                tvResultado.text = "Porfaplis, selecciona una divisa"
            } else {
                var resultado = ""
                if (cbDolar.isChecked) {
                    resultado += "%.2f C$\n".format(euros * 1.58)
                }
                if (cbLibra.isChecked) {
                    resultado += "%.2f £\n".format(euros * 0.84)
                }
                if (cbYen.isChecked) {
                    resultado += "%.2f ¥\n".format(euros * 176.0)
                }
                tvResultado.text = resultado
            }
        }
        btnBorrar.setOnClickListener {
            etCantidad.setText("")
            cbDolar.isChecked = false
            cbLibra.isChecked = false
            cbYen.isChecked = false
            tvResultado.text = ""
            etCantidad.requestFocus()
        }
    }
}