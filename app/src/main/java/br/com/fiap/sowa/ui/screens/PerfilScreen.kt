package br.com.fiap.sowa.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.sowa.ui.components.Header
import br.com.fiap.sowa.ui.components.NavBar
import br.com.fiap.sowa.ui.components.PerfilDados
import br.com.fiap.sowa.ui.components.PerfilHeader

@Composable
fun PerfilScreen( navController: NavController ) {
    var descricao: String = "Na escola do perfil, cada corredor é um portal para o conhecimento, onde os murais respiram inspiração e os corações pulsam aprendizado." +
            " Os sorrisos dos alunos são pinceladas de esperança e os lápis, instrumentos de criação." +
            " Nas salas de aula, as mentes curiosas se entrelaçam em debates e descobertas, enquanto os professores são faróis de sabedoria, guiando cada aluno em sua jornada educacional. "
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Header()
        PerfilHeader("José Barreto", "Teatro, Dança", "4/5", "222")
        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            item {
                PerfilDados("(11) 91234-5678", "email@gmail.com", "Av. Lins Vasconcelos, 5000 - São Paulo, SP", descricao = descricao)
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