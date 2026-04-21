package com.example.practica_4_ejercicio_4

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var imageView: ImageView
    private lateinit var progressBar: ProgressBar

    // launcher moderno
    private val takePictureLauncher = registerForActivityResult(
        ActivityResultContracts.TakePicturePreview()
    ) { bitmap ->
        progressBar.visibility = View.GONE

        if (bitmap != null) {
            imageView.setImageBitmap(bitmap)
        } else {
            Toast.makeText(this, "No se capturó imagen", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView = findViewById(R.id.imageView)
        progressBar = findViewById(R.id.progressBar)
        val botonFoto = findViewById<Button>(R.id.botonFoto)

        botonFoto.setOnClickListener {
            // barra de carga
            progressBar.visibility = View.VISIBLE

            takePictureLauncher.launch(null)
        }
    }
}