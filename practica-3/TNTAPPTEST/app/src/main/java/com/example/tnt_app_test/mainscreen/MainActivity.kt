package com.example.tnt_app_test.mainscreen

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tnt_app_test.mainscreen.view.PantallaPrincipal
import com.example.tnt_app_test.mainscreen.logic.MainViewModel

class MainActivity : ComponentActivity() {
    var contadorVidas = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("TNT_TAG", "----------On create log----------")
        setContent {
            val vm: MainViewModel = viewModel()
            PantallaPrincipal(vm)
        }
    }

    override fun onResume() {
        super.onResume()
        Log.d("TNT_TAG", "---------On resume log----------- Vidas: $contadorVidas")
        contadorVidas++
    }

    override fun onStart() {
        super.onStart()
        Log.d("TNT_TAG", "----------On start log--------- Vidas: $contadorVidas")
        contadorVidas++
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("TNT_TAG", "-----------On restart log-----------")
    }

    override fun onPause() {
        super.onPause()
        Log.d("TNT_TAG", "--------On pause log------------")
    }

    override fun onStop() {
        super.onStop()
        Log.d("TNT_TAG", "----------On stop log-----------")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("TNT_TAG", "--------On destroy log---------")
    }
}