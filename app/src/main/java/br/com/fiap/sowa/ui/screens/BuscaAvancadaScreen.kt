package br.com.fiap.sowa.ui.screens

import android.os.Build
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
import br.com.fiap.sowa.ui.components.BuscaAvancadaeMatch
import br.com.fiap.sowa.ui.components.Header
import br.com.fiap.sowa.ui.components.NavBar
import br.com.fiap.sowa.ui.components.HomeMatchPerfil
import br.com.fiap.sowa.ui.components.SearchBar
import br.com.fiap.sowa.ui.components.searchUsers
import com.google.accompanist.permissions.ExperimentalPermissionsApi


@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun BuscaAvancadaScreen(navController: NavController) {
    var usuarios by remember { mutableStateOf(emptyList<Usuario>()) }
    var currentIndex by remember { mutableStateOf(0) }

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
            .background(color = colorResource(id = R.color.superLightBlue))
    ) {
        Header()
        BuscaAvancadaeMatch(navController)
        SearchBar()

        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            item {

            }
        }
        NavBar(navController, "home")
    }
}
