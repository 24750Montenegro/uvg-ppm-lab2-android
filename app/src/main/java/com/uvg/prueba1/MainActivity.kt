package com.uvg.prueba1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.uvg.prueba1.ui.theme.Prueba1Theme
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Prueba1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )

                }
                Toast()
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hola $name!, bienvenido a mi primer pantalla usando Jetpack compose",
        modifier = modifier
    )
}

@Composable
fun Toast(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        androidx.compose.material3.Button(
            onClick = { displayToast(context, "Se suponía que no dieras click :/ ") },
            colors = androidx.compose.material3.ButtonDefaults.buttonColors(containerColor = androidx.compose.ui.graphics.Color(0Xd14f04cc))
        ) {
            androidx.compose.material3.Text(text = "No hagas click", color = androidx.compose.ui.graphics.Color.White)
        }
    }
}


private fun displayToast(context: Context, message: String) {
    Toast.makeText(context, message , Toast.LENGTH_LONG).show()
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Prueba1Theme {
        Greeting("Android")
    }
}