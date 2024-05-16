package br.com.fiap.sowa.ui.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.sowa.ui.screens.*

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun SetupNavigation() {
    val navController = rememberNavController()
    val context = LocalContext.current

    NavHost(
        navController = navController,
        startDestination = "login"
    ) {
        composable(route = "login") {
            LoginScreen(navController)
        }
        composable(route = "home") {
            HomeScreen(navController)
        }
        composable(route = "connections") {
            ConnectionsScreen(navController)
        }
        composable(route = "perfil") {
            PerfilScreen(navController)
        }
        composable(route = "cadastro") {
            CadastroScreen(navController)
        }
    }
}
