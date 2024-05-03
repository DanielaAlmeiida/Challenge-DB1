package br.com.fiap.sowa.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.sowa.R
import br.com.fiap.sowa.model.Usuario
import br.com.fiap.sowa.ui.components.Header
import br.com.fiap.sowa.ui.components.NavBar
import br.com.fiap.sowa.ui.components.CardPersonSearch
import br.com.fiap.sowa.ui.components.SearchBar
import br.com.fiap.sowa.ui.components.searchUsers

@Composable
fun HomeScreen(navController: NavController) {

    var usuarios by remember { mutableStateOf(emptyList<Usuario>()) }

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
        SearchBar()
        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            items(usuarios) { usuario ->
                CardPersonSearch(navController, nome = usuario.nome ?: "", areas = usuario.areas ?: "", estado = usuario.endereco?.uf ?: "", avaliacao = "4.5")
            }
        }
        NavBar(navController, "home")
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewHomeScreen() {
    val navController = rememberNavController()
    Box(modifier = Modifier.fillMaxSize()) {
        HomeScreen(navController = navController)
    }
}