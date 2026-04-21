package com.example.practica4

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ------------ EJERCICIO 1 ------------
        val campoTexto = findViewById<EditText>(R.id.campoTexto)
        val botonCompartir = findViewById<Button>(R.id.botonCompartir)

        botonCompartir.setOnClickListener {
            val texto = campoTexto.text.toString().trim()

            if (texto.isEmpty()) {
                Toast.makeText(this, "El texto no puede ser vacío", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, texto)
            }

            // validacion Android 11+
            if (intent.resolveActivity(packageManager) != null) {
                val chooser = Intent.createChooser(intent, "Compartir texto con...")
                startActivity(chooser)
            } else {
                Toast.makeText(this, "No hay aplicaciones disponibles para compartir", Toast.LENGTH_SHORT).show()
            }
        }

        // ------------ EJERCICIO 2 ------------
        val campoUrl = findViewById<EditText>(R.id.campoUrl)
        val botonAbrirNavegador = findViewById<Button>(R.id.botonAbrirNavegador)

        botonAbrirNavegador.setOnClickListener {
            var url = campoUrl.text.toString().trim()

            if (url.isEmpty()) {
                Toast.makeText(this, "Ingrese una URL", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!url.startsWith("http://") && !url.startsWith("https://")) {
                url = "https://$url"
            }

            val uri = Uri.parse(url)

            val intent = Intent(Intent.ACTION_VIEW, uri)


            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                Toast.makeText(this, "No hay navegador disponible", Toast.LENGTH_SHORT).show()
            }
        }

        // ------------ EJERCICIO 3 ------------
        // ------------ A) geolocalizacion ------------
        val campoUbicacion = findViewById<EditText>(R.id.campoUbicacion)
        val botonVerMapa = findViewById<Button>(R.id.botonVerMapa)

        botonVerMapa.setOnClickListener {
            val ubicacion = campoUbicacion.text.toString().trim()

            if (ubicacion.isEmpty()) {
                Toast.makeText(this, "Ingrese una ubicación", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val uri = Uri.parse("geo:0,0?q=${Uri.encode(ubicacion)}")

            val intent = Intent(Intent.ACTION_VIEW, uri)

            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                Toast.makeText(this, "No hay aplicación de mapas disponible", Toast.LENGTH_SHORT).show()
            }
        }

        // ------------ B) llamada telefonica ------------

        val campoTelefono = findViewById<EditText>(R.id.campoTelefono)
        val botonLlamar = findViewById<Button>(R.id.botonLlamar)

        botonLlamar.setOnClickListener {
            val numero = campoTelefono.text.toString().trim()

            if (numero.isEmpty()) {
                Toast.makeText(this, "Ingrese un número telefónico", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val uri = Uri.parse("tel:$numero")
            val intent = Intent(Intent.ACTION_DIAL, uri)

            // ¿Por que se usa DIAL en lugar de CALL?
            // La accion CALL realiza directamente una llamada al numero especificado.
            // La accion DIAL lo que hace es marcar el numero pero no realizar la llamada, lo cual es más seguro.
            // Además, con DIAL se puede modificar el numero marcado.
            // Fuente: https://www.tutorialspoint.com/android/android_phone_calls.htm

            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                Toast.makeText(this, "No hay aplicación de teléfono disponible", Toast.LENGTH_SHORT).show()
            }
        }
    }
}