package com.example.coroutinesapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.coroutinesapp.viewmodel.MainViewModel

@JvmOverloads
@Composable
fun CounterScreen(viewModel: MainViewModel = viewModel) {
    // Observa los cambios en el estado del ViewModel
    val countTime by remember { mutableStateOf(viewModel.countTime) }
    val secondCountTime by remember { mutableStateOf(viewModel.secondCountTime) }
    val resultState by remember { mutableStateOf(viewModel.resultState) }
    val isCounting by remember { mutableStateOf(viewModel.isCounting) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Primer Contador: $countTime")
        Text("Segundo Contador: $secondCountTime")
        Spacer(modifier = Modifier.height(16.dp))

        if (isCounting) {
            Button(
                onClick = { viewModel.cancelCounters() },
                modifier = Modifier.padding(8.dp)
            ) {
                Text("Cancelar Contadores")
            }
        } else {
            Button(
                onClick = { viewModel.startCounters() },
                modifier = Modifier.padding(8.dp)
            ) {
                Text("Iniciar Contadores")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Estado: $resultState")
    }
}

@Preview
@Composable
fun PreviewCounterScreen() {
    CounterScreen()
}