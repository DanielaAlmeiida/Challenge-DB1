package br.com.fiap.sowa.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.sowa.ui.screens.CadastroScreen

@Composable
fun BuscaAvancadaeMatch (navController:NavController) {
    var corMatch by remember { mutableStateOf(Color.Transparent) }
    var corBuscaAvancada by remember { mutableStateOf(Color.Transparent) }

    if (navController.currentBackStackEntry?.destination?.route == "home") {
        corMatch = Color.Transparent
        corBuscaAvancada = Color(0xFF098B6C)
    } else if (navController.currentBackStackEntry?.destination?.route == "buscaAvancada") {
        corMatch = Color(0xFF098B6C)
        corBuscaAvancada = Color.Transparent
    }
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding
                (top = 18.dp, bottom = 15.dp)

    ){
        Row(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(10.dp))
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(Color(0xFF6AD9BE), Color(0xFF17AE8A)),
                    )
                )
                .padding(horizontal = 45.dp)
                .height(32.dp),

            ) {
            Button(
                onClick = { navController.navigate("home") },
                colors = ButtonDefaults.buttonColors(corMatch),
                shape = RoundedCornerShape(10.dp),
            ) {
                Text(text = "Match", fontSize = 12.sp, color = Color.White)
            }

            Button(
                onClick = { navController.navigate("buscaAvancada") },
                colors = ButtonDefaults.buttonColors(corBuscaAvancada),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(text = "BuscaAvancada", fontSize = 12.sp, color = Color.White)
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Preview() {
    val navController = rememberNavController()
    Box(modifier = Modifier) {
        BuscaAvancadaeMatch(navController = navController)
    }
}