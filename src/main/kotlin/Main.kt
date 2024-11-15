import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
fun App() {
    MaterialTheme {
        Surface{
            var showScreen1 by remember {mutableStateOf(true)}
            if (showScreen1) {
                screen1(showScreen1)
            } else {
                screen2()
            }
        }
    }
}

@Composable
fun screen1(showScreen: Boolean) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Bienvenido a la peor app del mercado!")
        Button(onClick = {}) {
            Text(text = "Entrar")
        }
    }
}

@Composable
fun screen2() {

}


fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
