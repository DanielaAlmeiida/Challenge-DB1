package br.com.fiap.sowa.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.sowa.model.UserEndereco
import br.com.fiap.sowa.model.UsuarioId
import br.com.fiap.sowa.ui.components.Header
import br.com.fiap.sowa.ui.components.NavBar
import br.com.fiap.sowa.ui.components.PerfilDados
import br.com.fiap.sowa.ui.components.PerfilHeader
import br.com.fiap.sowa.ui.components.getUserById
import br.com.fiap.sowa.ui.components.searchUsersId

@Composable
fun PerfilScreen( navController: NavController ) {
    var usuario by remember { mutableStateOf(
        UsuarioId("", "", "", "", "", "", "", "", "", UserEndereco("", "Av. Lins Vasconcelos", "São paulo", "Osasco", "SP", "06020-194"))
    ) }
    var usuarios by remember { mutableStateOf(emptyList<UsuarioId>()) }
    var usersId by remember { mutableStateOf(mutableListOf<String>()) }
    var ultimoUsuarioId by remember { mutableStateOf("") }

    var descricao: String = "Na escola do perfil, cada corredor é um portal para o conhecimento, onde os murais respiram inspiração e os corações pulsam aprendizado." +
            " Os sorrisos dos alunos são pinceladas de esperança e os lápis, instrumentos de criação." +
            " Nas salas de aula, as mentes curiosas se entrelaçam em debates e descobertas, enquanto os professores são faróis de sabedoria, guiando cada aluno em sua jornada educacional. "

    LaunchedEffect(Unit) {
        searchUsersId { usuariosResult ->
            usuariosResult?.let {
                usuarios = it
                // Extrai os IDs de usuário
                for (usuario in usuarios) {
                    usuario._id?.let { usersId.add(it) }
                }
                // Obtém o último ID de usuário, se a lista não estiver vazia
                if (usersId.isNotEmpty()) {
                    ultimoUsuarioId = usersId.last()
                    // Busca o usuário com o último ID
                    getUserById(ultimoUsuarioId) { usuarioObtido ->
                        usuario = usuarioObtido ?: UsuarioId("65f87ca0fc9ff5537fe2b40a", "E.E. Prof José Barreto", "Teatro, Dança", "4/5", "222", "(11) 91234-5678", "email@gmail.com", "", "", UserEndereco("", "Av. Lins Vasconcelos", "São Paulo", "Osasco", "SP", "06020-194"))
                    }
                }
            }
        }
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Header()
        PerfilHeader(usuario.nome?:"José Barreto", usuario.areas?:"Teatro, Dança", "4/5", "222")
        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            item {
                PerfilDados(
                    usuario.telefone?: "(11) 91234-5678",
                    usuario.email?: "email@gmail.com",
                    usuario.endereco?.cidade ?: "Av. Lins Vasconcelos, 5000 - São Paulo, SP",
                    descricao = usuario.experiencias?: descricao)
            }
        }
        NavBar(navController, "perfil")
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewPerfilScreen() {
    val navController = rememberNavController()
    Box(modifier = Modifier.fillMaxSize()) {
        PerfilScreen(navController = navController)
    }
}