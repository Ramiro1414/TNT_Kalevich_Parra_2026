package com.example.practica_4_ejercicio_5_y_6

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import kotlin.jvm.java

class MainActivity : AppCompatActivity() {

    private lateinit var etNombre: EditText

    private val launcher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->

        if (result.resultCode == RESULT_OK) {
            val nuevoNombre = result.data?.getStringExtra("nombre_editado")
            if (!nuevoNombre.isNullOrEmpty()) {
                etNombre.setText(nuevoNombre)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etNombre = findViewById(R.id.etNombre)
        val btnSiguiente = findViewById<Button>(R.id.btnSiguiente)

        val tvTextoCompartido = findViewById<TextView>(R.id.tvTextoCompartido)

        manejarIntent(intent, tvTextoCompartido)

        btnSiguiente.setOnClickListener {
            val nombre = etNombre.text.toString().trim()

            if (nombre.isEmpty()) {
                Toast.makeText(this, "Ingrese un nombre", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this, ActividadSecundaria::class.java)
            intent.putExtra("nombre", nombre)

            launcher.launch(intent)
        }
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)

        val tvTextoCompartido = findViewById<TextView>(R.id.tvTextoCompartido)
        manejarIntent(intent, tvTextoCompartido)
    }

    private fun manejarIntent(intent: Intent, textView: TextView) {
        if (intent.action == Intent.ACTION_SEND && intent.type == "text/plain") {
            val texto = intent.getStringExtra(Intent.EXTRA_TEXT)

            if (!texto.isNullOrEmpty()) {
                textView.text = texto
            }
        }
    }

    class ActividadSecundaria : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.actividad_secundaria)

            val tvSaludo = findViewById<TextView>(R.id.tvSaludo)
            val etEditarNombre = findViewById<EditText>(R.id.etEditarNombre)
            val btnVolver = findViewById<Button>(R.id.btnVolver)

            // recepcion de datos
            val nombre = intent.getStringExtra("nombre") ?: ""

            tvSaludo.text = "Hola, $nombre. Bienvenido."
            etEditarNombre.setText(nombre)

            btnVolver.setOnClickListener {
                val nombreEditado = etEditarNombre.text.toString().trim()

                val resultIntent = Intent().apply {
                    putExtra("nombre_editado", nombreEditado)
                }

                setResult(RESULT_OK, resultIntent)
                finish()
            }
        }
    }
}