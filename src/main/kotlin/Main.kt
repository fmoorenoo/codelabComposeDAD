import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
fun App() {
    MaterialTheme {
        Surface{
//            var showScreen1 by remember {mutableStateOf(true)}
//            if (showScreen1) {
//                screen1(showScreen1)
//            } else {
//                screen2()
//            }
            screen2()
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
    val textos = arrayOf(
        "Holalojfiuaehfef",
        "Hieufhewufhqeuif",
        "Holalojdaehfef",
        "Hieufhewusssssfhqeuif",
        "Hieufhdheuif",
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
            .padding(30.dp),
        verticalArrangement = Arrangement.spacedBy(15.dp),

    ) {
        textos.forEach { texto ->
            var expanded by remember { mutableStateOf(false)}
            var currentPadding by remember { mutableIntStateOf(0) }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.LightGray)
                    .padding(vertical = 10.dp, horizontal = 15.dp)
                    .padding(bottom = currentPadding.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically

            ) {
                Text(texto)
                Button(onClick = {
                    expanded = !expanded
                    currentPadding = if (!expanded) 0 else 50
                }) {
                    Text(text = if (expanded) "Show less" else "Show more")
                }
            }
        }
    }
}


fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
