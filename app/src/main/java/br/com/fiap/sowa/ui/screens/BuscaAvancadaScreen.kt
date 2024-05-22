package br.com.fiap.sowa.ui.screens

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.sowa.R
import br.com.fiap.sowa.model.Usuario
import br.com.fiap.sowa.model.UsuarioHome
import br.com.fiap.sowa.ui.components.BuscaAvancadaeMatch
import br.com.fiap.sowa.ui.components.CardPersonSearchAdvanced
import br.com.fiap.sowa.ui.components.Header
import br.com.fiap.sowa.ui.components.NavBar
import br.com.fiap.sowa.ui.components.RadioButtonArea
import br.com.fiap.sowa.ui.components.SearchBar
import br.com.fiap.sowa.ui.components.SearchBarAdvanced
import br.com.fiap.sowa.ui.components.searchUsers
import br.com.fiap.sowa.ui.components.searchUsersByPrompt
import com.google.accompanist.permissions.ExperimentalPermissionsApi


@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun BuscaAvancadaScreen(navController: NavController) {
    var usuarios by remember { mutableStateOf(emptyList<Usuario>()) }
    //var currentIndex by remember { mutableStateOf(0) }
    var filtroSelecionado by remember { mutableStateOf<String?>(null) }
    var searchText by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        searchUsers { usuarioResult ->
            usuarioResult?.let {
                usuarios = it
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
            .background(color = colorResource(id = R.color.superLightBlue))
    ) {
        Header()
        BuscaAvancadaeMatch(navController)

        // Uso do componente RadioButton para filtroSelecionado
        Text(
            text = "Selecione a área:",
            fontWeight = FontWeight.Bold
        )
        Row {
            Column{
                RadioButtonArea(
                    nome = "Matemática",
                    isSelected = searchText == "Matemática",
                    onSelected = {
                        searchText = "Matemática"
                    }
                )
                RadioButtonArea(
                    nome = "Geografia",
                    isSelected = searchText == "Geografia",
                    onSelected = {
                        searchText = "Geografia"
                    }
                )
                RadioButtonArea(
                    nome = "História",
                    isSelected = searchText == "história",
                    onSelected = {
                        searchText = "história"
                    }
                )
            }
            Column {
                RadioButtonArea(
                    nome = "Química",
                    isSelected = searchText == "química",
                    onSelected = {
                        searchText = "química"
                    }
                )
                RadioButtonArea(
                    nome = "Biologia",
                    isSelected = searchText == "biologia",
                    onSelected = {
                        searchText = "biologia"
                    }
                )
                RadioButtonArea(
                    nome = "Inglês",
                    isSelected = searchText == "inglês",
                    onSelected = {
                        searchText = "inglês"
                    }
                )
            }
        }

        //SearchBarAdvanced(filtroSelecionado) //Campo de pesquisa

        var usuarios by remember { mutableStateOf(emptyList<UsuarioHome>()) }
        var prompt by remember { mutableStateOf("") }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .padding(0.dp, 0.dp, 0.dp, 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedButton(
                onClick = {
                    prompt = searchText
                    Log.d("Usuários filtro prompt", "Usuários filtro carregados prompt: $prompt")

                    searchUsersByPrompt(prompt) { usuariosPrompt ->
                        usuariosPrompt?.let {
                            usuarios = it
                            Log.d("Usuários filtro", "Usuários filtro carregados: $usuarios")
                        }
                    }
                },
                colors = ButtonDefaults.buttonColors(colorResource(id = R.color.white)),
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier
                    .padding(0.dp, 0.dp, 10.dp, 0.dp)
                    .fillMaxHeight(.8f),
                content = {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_search_24),
                        contentDescription = null,
                        tint = colorResource(id = R.color.grayPrincipal)
                    )
                }
            )
        }

        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            items(usuarios) {
                CardPersonSearchAdvanced(usuarioHome = it)
            }
        }

        NavBar(navController, "home")
    }
}
