package com.tuempresa.vetturnos

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.tuempresa.vetturnos.R

@Composable
fun LoginScreen(navController: NavHostController) {
    val context = LocalContext.current
    var usuario by remember { mutableStateOf("") }
    var clave by remember { mutableStateOf("") }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier
                    .size(150.dp)
                    .padding(bottom = 24.dp)
            )

            Text(
                text = "Bienvenido a VetTurnos",
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(24.dp))

            OutlinedTextField(
                value = usuario,
                onValueChange = { usuario = it },
                label = { Text("Usuario (correo)") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )

            OutlinedTextField(
                value = clave,
                onValueChange = { clave = it },
                label = { Text("Contraseña") },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {
                    val user = UserManager.authenticate(usuario.trim(), clave)
                    if (user != null) {
                        Toast.makeText(context, "Bienvenido ${user.correo}", Toast.LENGTH_LONG).show()
                        if (user.rol == "admin") {
                            navController.navigate("dashboard") {
                                popUpTo("login") { inclusive = true }
                            }
                        } else {
                            navController.navigate("principal") {
                                popUpTo("login") { inclusive = true }
                            }
                        }
                    } else {
                        Toast.makeText(context, "Credenciales incorrectas", Toast.LENGTH_SHORT).show()
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = MaterialTheme.shapes.large
            ) {
                Text("Iniciar sesión")
            }

            Spacer(modifier = Modifier.height(16.dp))

            TextButton(onClick = { navController.navigate("registro") }) {
                Text("¿No tienes cuenta? Regístrate")
            }
        }
    }
}
