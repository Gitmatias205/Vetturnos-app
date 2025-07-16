package com.tuempresa.vetturnos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.tuempresa.vetturnos.ui.theme.VetturnosTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializar Firebase
        FirebaseAuth.getInstance()
        FirebaseStorage.getInstance()
        FirebaseFirestore.getInstance()

        setContent {
            VetturnosTheme {
                AppNavigator() // Controlador de navegación
            }
        }
    }
}
