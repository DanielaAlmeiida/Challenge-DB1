package br.com.fiap.sowa.ui.screens

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.navigation.NavController
import br.com.fiap.sowa.R
import br.com.fiap.sowa.model.Endereco
import br.com.fiap.sowa.model.Usuario
import br.com.fiap.sowa.model.UsuarioHome
import br.com.fiap.sowa.ui.components.BuscaAvancadaeMatch
import br.com.fiap.sowa.ui.components.Header
import br.com.fiap.sowa.ui.components.NavBar
import br.com.fiap.sowa.ui.components.HomeMatchPerfil
import br.com.fiap.sowa.ui.components.SearchBar
import br.com.fiap.sowa.ui.components.searchUsers
import br.com.fiap.sowa.ui.components.searchUsersHome
import com.google.accompanist.permissions.ExperimentalPermissionsApi


@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun HomeScreen(navController: NavController) {
    var usuarios by remember { mutableStateOf(emptyList<UsuarioHome>()) }
    var currentIndex by remember { mutableStateOf(0) }

    LaunchedEffect(Unit) {
        searchUsersHome { usuarioResult ->
            usuarioResult?.let {
                usuarios = it
                Log.d("Perfis", "Usuários carregados: $it")
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.superLightBlue))
    ) {
        Header()
        BuscaAvancadaeMatch(navController)

        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            item {
                HomeMatchPerfil(
                    nome = usuarios.getOrNull(currentIndex)?.nome ?: "",
                    experiencias = usuarios.getOrNull(currentIndex)?.experiencias ?: "",
                    academicas = usuarios.getOrNull(currentIndex)?.academicas ?: "",
                    tipo = usuarios.getOrNull(currentIndex)?.tipo ?: "",
                    telefone = usuarios.getOrNull(currentIndex)?.telefone ?: "",
                    areas = usuarios.getOrNull(currentIndex)?.areas ?: "",
                    endereco = usuarios.getOrNull(currentIndex)?.endereco ?: Endereco("", "", "", "", ""),
                    avaliacao = "5"
                ) {
                    // Avança para o próximo perfil
                    currentIndex = (currentIndex + 1) % usuarios.size
                }

            }
        }
        NavBar(navController, "home")
    }
}
