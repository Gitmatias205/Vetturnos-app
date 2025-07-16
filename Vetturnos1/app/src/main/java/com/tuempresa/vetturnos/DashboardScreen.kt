// DashboardScreen.kt
package com.tuempresa.vetturnos

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun DashboardScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp, Alignment.Top),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Panel de Control",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary
        )

        Button(
            onClick = { /* Acceder a lista de usuarios o citas */ },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)
        ) {
            Icon(Icons.Default.List, contentDescription = null)
            Spacer(modifier = Modifier.width(8.dp))
            Text("Ver usuarios o citas")
        }

        Button(
            onClick = { /* Configuraciones futuras */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(Icons.Default.Settings, contentDescription = null)
            Spacer(modifier = Modifier.width(8.dp))
            Text("Configuración")
        }

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = { navController.navigate("login") },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error)
        ) {
            Text("Cerrar sesión")
        }
    }
}