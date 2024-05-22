package br.com.fiap.sowa.ui.components

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import br.com.fiap.sowa.R
import br.com.fiap.sowa.model.Usuario
import br.com.fiap.sowa.model.UsuarioHome


//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SearchBarAdvanced(filtroSelecionado: String?) {
    var searchText by remember { mutableStateOf("") }
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
        OutlinedTextField(
            shape = RoundedCornerShape(50.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                disabledContainerColor = Color.White,
            ),
            modifier = Modifier
                .padding(20.dp, 0.dp),
            value = searchText,
            onValueChange = { searchText = it },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            label = {
                Text(text = "Pesquisar")
            },
            placeholder = {
                Text(text = "Pesquisar...")
            }
        )

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
}