package br.com.fiap.sowa.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.sowa.R


@Composable
fun PerfilDados(telefone: String, email: String, endereco: String, descricao: String) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp)
            .padding(20.dp)
    ) {
        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxWidth()
        ){
            Text(
                text = "Informações acadêmicas",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.DarkGray
            )
            Spacer(modifier = Modifier.height(6.dp))
            PerfilComponenteDado(text = "•", dado = endereco)
            PerfilComponenteDado(text = "•", dado = endereco)
            Spacer(modifier = Modifier.height(16.dp))
        }

        LazyColumn (
            modifier = Modifier.weight(1f)
        ) {
            item {
                Text(
                    text = "Experiência",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.DarkGray,
                )
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(0.dp, 12.dp, 0.dp, 12.dp),
                    shape = RoundedCornerShape(12.dp),
                    color = colorResource(id = R.color.lightGray2)
                )  {
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                            text = descricao,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Light,
                            color = Color.Black,
                            modifier = Modifier .padding(14.dp)
                        )
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }

        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxWidth()
        ){
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Contato",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.DarkGray,
            )
            Spacer(modifier = Modifier.height(6.dp))
            PerfilComponenteDado(text = "Telefone: ", dado = telefone)
            PerfilComponenteDado(text = "Email: ", dado = email)
            PerfilComponenteDado(text = "Endereço: ", dado = endereco)
        }

    }
}