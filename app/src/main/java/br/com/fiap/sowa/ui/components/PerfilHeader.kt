package br.com.fiap.sowa.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.sowa.R

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewPerfilHeader() {
    val navController = rememberNavController()
    Box(modifier = Modifier.fillMaxSize()) {
        PerfilHeader("E.E. Prof José Barreto", "Teatro, Dança", "4/5", "222")
    }
}

@Composable
fun PerfilHeader(nome: String, areas: String, avaliacao: String, numbConnections: String) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
            .shadow(6.dp)
            .background(
                brush = androidx.compose.ui.graphics.Brush.horizontalGradient(
                    colors = listOf(Color(0xFF6AD9BE), Color(0xFF17AE8A)),
                    startX = 0f,
                    endX = 900f
                )
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(140.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .height(280.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.person),
                    contentDescription = "Ícone de pessoa",
                    modifier = Modifier
                        .size(100.dp)
                        .padding(5.dp)
                )
            }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .height(180.dp)
            ) {
                Text(
                    text = nome,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Row(
                    modifier = Modifier.padding(top = 4.dp, bottom = 8.dp)
                ) {
                    Text(
                        text = "Mentor em: ",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Light,
                        color = Color.White
                    )
                    Text(
                        text = areas,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Light,
                        color = Color.White
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))

                Row {
                    AreaInteresse(nomeAreaInteresse = "TEATRO", corAreaInteresse = Color.Red)
                    AreaInteresse(nomeAreaInteresse = "DANCA", corAreaInteresse = Color.Blue)
                    AreaInteresse(nomeAreaInteresse = "ROBOTICA", corAreaInteresse = Color.Gray)
                    AreaInteresse(nomeAreaInteresse = "CIENCIA", corAreaInteresse = Color.Cyan)
                }
                Row(
                    modifier = Modifier.padding(top = 8.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_location_on_24),
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "São Paulo - SP",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Light,
                        color = Color.White,
                    )
                }

            }
        }

        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            PerfilHeaderDados(
                descricao = "Ícone de avaliação",
                iconId = R.drawable.baseline_star_24,
                color = Color.White,
                texto = avaliacao
            )
            PerfilHeaderDados(
                descricao = "Ícone de connects",
                iconId = R.drawable.connect,
                color = Color.White,
                texto = numbConnections
            )
            PerfilHeaderDados(
                descricao = "Ícone de configurações",
                iconId = R.drawable.settings,
                color = Color.White,
                texto = "Editar perfil"
            )
        }
    }
}