import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
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
import androidx.compose.ui.unit.coerceAtLeast
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
fun App() {
    MaterialTheme {
        Surface{
            var showScreen1 by remember {mutableStateOf(true)}
            if (showScreen1) {
                screen1(showScreen = {showScreen1 = false})
            } else {
                screen2()
            }
        }
    }
}

@Composable
fun screen1(showScreen: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Bienvenido a la peor app del mercado!")
        Button(onClick = showScreen) {
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
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        textos.forEach { texto ->
            var expanded by remember { mutableStateOf(false)}

            val animationPadding by
            animateDpAsState(
                if (expanded) 48.dp else 0.dp,
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
            var currentPadding = animationPadding.coerceAtLeast(0.dp)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.LightGray)
                    .padding(vertical = 10.dp, horizontal = 15.dp)
                    .padding(bottom = currentPadding),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically

            ) {
                Text(texto)
                Button(onClick = {
                    expanded = !expanded
                    currentPadding = if (!expanded) 0.dp else 50.dp
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
