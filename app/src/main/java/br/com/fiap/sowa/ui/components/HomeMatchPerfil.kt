package br.com.fiap.sowa.ui.components

import android.Manifest
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.sowa.R
import br.com.fiap.sowa.model.Endereco
import br.com.fiap.sowa.model.NotificationHandler
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun HomeMatchPerfil(
    nome: String,
    experiencias: String,
    academicas: String,
    email: String,
    senha: String,
    tipo: String,
    telefone: String,
    areas: String,
    endereco: Any,
    avaliacao: String,
    numbConnections: String,
    onNextClick: () -> Unit
) {
    val context = LocalContext.current
    val postNotificationPermission = rememberPermissionState(permission = Manifest.permission.POST_NOTIFICATIONS)
    val notificationHandler = remember { NotificationHandler(context) }

    LaunchedEffect(key1 = true) {
        if (!postNotificationPermission.status.isGranted) {
            postNotificationPermission.launchPermissionRequest()
        }
    }

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
                AreaInteresse(nomeAreaInteresse = areas, corAreaInteresse = Color.Red)
                AreaInteresse(nomeAreaInteresse = areas, corAreaInteresse = Color.Blue)
                AreaInteresse(nomeAreaInteresse = areas, corAreaInteresse = Color.Gray)
                AreaInteresse(nomeAreaInteresse = areas, corAreaInteresse = Color.Cyan)
            }
            Spacer(modifier = Modifier.height(8.dp))
            /*
            endereco.localidade?.let {
                Text(
                    text = it,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Light,
                    color = Color.White
                )
            }
            */

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
            PerfilComponenteDado(text = "-", dado = academicas)
            PerfilComponenteDado(text = "-", dado = academicas)

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
                    text = experiencias,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Light,
                    color = Color.Black,
                    modifier = Modifier .padding(14.dp)
                )
            }

        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .background(color = Color.White)
                .border(width = 1.dp, color = Color.Gray)
        ) {
            Button(
                onClick = {
                    /* Não Match */
                    onNextClick() // Avança para o próximo perfil
                },
                shape = RoundedCornerShape(50.dp),
                colors = ButtonDefaults.buttonColors(Color.White),
                modifier = Modifier.size(100.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.circle_close),
                    contentDescription = "Ícone de negação",
                    tint = Color.Red,
                    modifier = Modifier.size(100.dp)
                )
            }

            Text(
                text = "Match",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Gray,
                modifier = Modifier.padding(14.dp)
            )

            Button(
                onClick = {
                    notificationHandler.showExpandedNotificationWithBigText() // Dispara a notificação pushup ao dar match
                    onNextClick() // Avança para o próximo perfil
                },
                shape = RoundedCornerShape(50.dp),
                colors = ButtonDefaults.buttonColors(Color.White),
                modifier = Modifier.size(100.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.circle_check),
                    contentDescription = "Ícone de afirmação",
                    tint = Color(0xFF17AE8A),
                    modifier = Modifier.size(100.dp)
                )
            }
        }
    }
}

