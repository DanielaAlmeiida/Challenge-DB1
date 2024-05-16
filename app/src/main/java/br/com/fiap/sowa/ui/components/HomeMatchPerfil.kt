package br.com.fiap.sowa.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import br.com.fiap.sowa.R
import br.com.fiap.sowa.ui.screens.HomeScreen

@Composable
fun HomeMatchPerfil(nome: String, areas: String, avaliacao: String, numbConnections: String) {
        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .shadow(6.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(Color(0xFF6AD9BE), Color(0xFF17AE8A)),
                        startX = 0f,
                        endX = 900f
                    )
                )
        ){
            Column (
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(10.dp)
            ){
                Button(
                    onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(50.dp),
                    colors = ButtonDefaults.buttonColors(Color.White),
                    modifier = Modifier
                        .height(80.dp)
                        .width(80.dp)
                        .padding(0.dp, 0.dp, 5.dp, 0.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.person),
                        contentDescription = "Ícone de pessoa",
                        tint = Color.Black,
                        modifier = Modifier.size(90.dp)
                    )
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    StarIcon()
                    StarIcon()
                    StarIcon()
                    StarIcon()
                    StarIcon()
                    Text(
                        text = avaliacao,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            Column (
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .height(120.dp)
            ){
                Text(
                    text = nome,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold ,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Mentor em: " + areas,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Light,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row {
                    AreaInteresse(nomeAreaInteresse = "DADO", corAreaInteresse = Color.Red)
                    AreaInteresse(nomeAreaInteresse = "DADO", corAreaInteresse = Color.Blue)
                    AreaInteresse(nomeAreaInteresse = "DADO", corAreaInteresse = Color.Gray)
                    AreaInteresse(nomeAreaInteresse = "DADO", corAreaInteresse = Color.Cyan)
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "São Paulo - SP",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Light,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(8.dp))
            }

            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .background(Color.White)
                    .padding(20.dp)
            ){
                Text(
                    text = "Informações acadêmicas",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                PerfilComponenteDado(text = "-", dado = "dado")
                PerfilComponenteDado(text = "-", dado = "dado")

                Spacer(modifier = Modifier.height(2.dp))

                Text(
                    text = "Experiência",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                )
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp, 12.dp, 0.dp, 12.dp),
                    shape = RoundedCornerShape(12.dp),
                    color = colorResource(id = R.color.lightGray2)
                ) {
                    Text(
                        text = "dado descricao dado descricao dado descricao dado descricao dado descricao dado descricao dado descricao dado descricao",
                        fontSize = 523.sp,
                        fontWeight = FontWeight.Light,
                        color = Color.Black,
                        modifier = Modifier .padding(14.dp)
                    )
                }

            }

            Row (
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .background(color = Color.White)
                    .border(width = 1.dp, color = Color.Gray)

            ){
                Button(
                    onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(50.dp),
                    colors = ButtonDefaults.buttonColors(Color.White),
                    modifier = Modifier
                        .size(100.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.circle_close),
                        contentDescription = "Ícone de pessoa",
                        tint = Color.Red,
                        modifier = Modifier.size(100.dp)
                    )
                }

                Text(
                    text = "Match",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray,
                    modifier = Modifier .padding(14.dp)
                )

                Button(
                    onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(50.dp),
                    colors = ButtonDefaults.buttonColors(Color.White),
                    modifier = Modifier
                        .size(100.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.circle_check),
                        contentDescription = "Ícone de pessoa",
                        tint = Color(0xFF17AE8A),
                        modifier = Modifier.size(100.dp)
                    )
                }
            }
        }
    }


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewHomeMatchPerfil() {
    val navController = rememberNavController()
    Box(modifier = Modifier.fillMaxSize()) {
        HomeMatchPerfil("E.E. Prof José Barreto", "Teatro, Dança", "4/5", "222")
    }
}