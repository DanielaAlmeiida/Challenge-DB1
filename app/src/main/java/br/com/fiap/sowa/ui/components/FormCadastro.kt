package br.com.fiap.sowa.ui.components

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.sowa.R
import br.com.fiap.sowa.model.Endereco
import br.com.fiap.sowa.model.UserEndereco
import br.com.fiap.sowa.model.Usuario
import br.com.fiap.sowa.service.RetrofitFactory
import br.com.fiap.sowa.service.UsuarioService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun FormCadastro(navController: NavController) {
    var aprendizDestaque by remember { mutableStateOf(true) }
    var mentorDestaque by remember { mutableStateOf(false) }
    var endereco by remember { mutableStateOf(Endereco("", "", "", "", "")) }
    var nome by remember { mutableStateOf("") }
    var tipo by remember { mutableStateOf("Aprendiz") }
    var experiencias by remember { mutableStateOf("") }
    var academicas by remember { mutableStateOf("") }
    var telefone by remember { mutableStateOf("") }
    var cep by remember { mutableStateOf("") }
    var areaSelecionada by remember { mutableStateOf<String?>(null) }
    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    var csenha by remember { mutableStateOf("") }
    var isPasswordVisible by remember { mutableStateOf(false) }
    var isConfirmedPasswordVisible by remember { mutableStateOf(false) }
    var usuario by remember { mutableStateOf(
        Usuario("", "", "", "", "", "", "", "", "")) }
    var enderecos by remember { mutableStateOf(emptyList<UserEndereco>()) }
    var enderecosId by remember { mutableStateOf(mutableListOf<String>()) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(horizontal = 64.dp)
    )

    {
        Text(
            text = "Você é um(a)",
            fontSize = 15.sp,
            color = Color.Black,
            textAlign = TextAlign.Left,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        Box {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = {
                        aprendizDestaque = true
                        mentorDestaque = false
                        tipo = "Aprendiz"
                    },
                    shape = RoundedCornerShape(10.dp),
                    colors = if (aprendizDestaque) ButtonDefaults.buttonColors(colorResource(id = R.color.greenPrincipal)) else
                        ButtonDefaults.buttonColors(colorResource(id = R.color.white)),
                    border = BorderStroke(1.dp, colorResource(id = R.color.greenPrincipal)),
                    modifier = Modifier
                        .width(100.dp)
                        .height(35.dp)
                ) {
                    Text(
                        text = "Aprendiz",
                        color = if (aprendizDestaque) Color.White else colorResource(id = R.color.greenPrincipal),
                        fontSize = 12.sp,
                    )
                }

                Button(
                    onClick = {
                        aprendizDestaque = false
                        mentorDestaque = true
                        tipo = "Mentor"
                    },
                    colors = if (mentorDestaque) ButtonDefaults.buttonColors(colorResource(id = R.color.greenPrincipal)) else
                        ButtonDefaults.buttonColors(colorResource(id = R.color.white)),
                    border = BorderStroke(1.dp, colorResource(id = R.color.greenPrincipal)),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .width(120.dp)
                        .height(35.dp)
                ) {
                    Text(
                        text = "Mentor",
                        color = if (mentorDestaque) Color.White else colorResource(id = R.color.greenPrincipal),
                        fontSize = 12.sp,
                    )
                }
            }
        }

        OutlinedTextFieldModel(
            value = nome,
            label = "Nome",
            placeholder = "Digite seu nome",
            modifier = Modifier,
            keyboardType = KeyboardType.Text,
            atualizarValor = { nome = it },
        )
        OutlinedTextFieldModel(
            value = experiencias,
            label = "Experiências",
            placeholder = "Digite suas experiências",
            modifier = Modifier,
            keyboardType = KeyboardType.Text,
            atualizarValor = { experiencias = it },
        )
        OutlinedTextFieldModel(
            value = academicas,
            label = "Acadêmicas",
            placeholder = "Digite suas acadêmicas",
            modifier = Modifier,
            keyboardType = KeyboardType.Text,
            atualizarValor = { academicas = it },
        )
        OutlinedTextFieldModel(
            value = telefone,
            label = "Telefone",
            placeholder = "Digite seu telefone",
            modifier = Modifier,
            keyboardType = KeyboardType.Text,
            atualizarValor = { telefone = it },
        )

        // Uso do Dropdown
        //DropdownMenuModel()

        // Uso do componente RadioButton
        Text(
            text = "Área de Interesse:",
            fontWeight = FontWeight.Bold
        )
        Row {
            Column{
                RadioButtonArea(
                    nome = "Matemática",
                    isSelected = areaSelecionada == "Matemática",
                    onSelected = {
                        areaSelecionada = "Matemática"
                    }
                )
                RadioButtonArea(
                    nome = "História",
                    isSelected = areaSelecionada == "História",
                    onSelected = {
                        areaSelecionada = "História"
                    }
                )
                RadioButtonArea(
                    nome = "Geografia",
                    isSelected = areaSelecionada == "Geografia",
                    onSelected = {
                        areaSelecionada = "Geografia"
                    }
                )
            }
            Column {
                RadioButtonArea(
                    nome = "Química",
                    isSelected = areaSelecionada == "Química",
                    onSelected = {
                        areaSelecionada = "Química"
                    }
                )
                RadioButtonArea(
                    nome = "Biologia",
                    isSelected = areaSelecionada == "Biologia",
                    onSelected = {
                        areaSelecionada = "Biologia"
                    }
                )
                RadioButtonArea(
                    nome = "Inglês",
                    isSelected = areaSelecionada == "Inglês",
                    onSelected = {
                        areaSelecionada = "Inglês"
                    }
                )
            }
        }


        OutlinedTextField(
            value = cep,
            onValueChange = { cep = it },
            label = {
                Row {
                    Text("CEP")
                    Text(
                        text = "*",
                        color = Color.Red
                    )
                }
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Number
            ),
            shape = RoundedCornerShape(10.dp),
            keyboardActions = KeyboardActions(onDone = {
                searchCep(cep) { enderecoResult ->
                    endereco = enderecoResult ?: Endereco(
                        "",
                        "",
                        "",
                        "",
                        "",
                    )
                }
            }),

            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
                searchCep(cep) { enderecoResult ->

                    endereco = enderecoResult ?: Endereco( "", "", "", "", "")
                    val address = Endereco(
                        endereco.logradouro,
                        endereco.localidade,
                        endereco.uf,
                        endereco.bairro,
                        endereco.cep
                    )

                    cadastrarEndereco(
                        address,
                        onSuccess = { "Sucesso" },
                        onFailure = {throwable -> "Falha no endereço" })

                }


            },
            enabled = cep.isNotBlank(),
            modifier = Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),
            colors = if (cep.isNotBlank()) ButtonDefaults.buttonColors(colorResource(id = R.color.greenPrincipal))
            else ButtonDefaults.buttonColors(colorResource(id = R.color.white))
        ) {
            Text("Buscar Endereço")
        }
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = endereco.logradouro ?: "",
            onValueChange = { endereco.logradouro = it },
            label = { Text("Endereço") },
            enabled = false,
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = endereco.bairro ?: "",
            onValueChange = { endereco.bairro = it },
            label = { Text("Bairro") },
            enabled = false,
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = endereco.localidade ?: "",
            onValueChange = { endereco.localidade = it },
            label = { Text("Cidade") },
            enabled = false,
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = endereco.uf ?: "",
            onValueChange = { endereco.uf = it },
            label = { Text("Estado") },
            enabled = false,
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextFieldModel(
            value = email,
            label = "E-mail",
            placeholder = "Digite seu e-mail",
            modifier = Modifier,
            keyboardType = KeyboardType.Email,
            atualizarValor = { email = it },
            isMandatory = true
        )
        OutlinedTextFieldPassword(
            senha = senha,
            onSenhaChange = { novaSenha ->
                senha = novaSenha
            },
            isPasswordVisible = isPasswordVisible,
            onPasswordVisibilityChange = { visibilidade ->
                isPasswordVisible = visibilidade
            },
            isMandatory = true,
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextFieldPassword(
            senha = csenha,
            onSenhaChange = { confirmarNovaSenha ->
                csenha = confirmarNovaSenha
            },
            isPasswordVisible = isConfirmedPasswordVisible,
            onPasswordVisibilityChange = { visibilidade ->
                isConfirmedPasswordVisible = visibilidade
            },
            isConfirmarSenha = true,
            isMandatory = true
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                // Chama a função searchEnderecos e processa o resultado no callback
                searchEnderecos { enderecoObtido ->
                    enderecoObtido?.let {
                        enderecos = it
                        Log.d("EnderecoID searchEnderecos", "ID do endereço searchEnderecos: ${enderecoObtido}")

                        for (end in enderecos) {
                            enderecosId.add(end._id)
                            Log.d("EnderecoID do for", "ID do endereço: ${end._id}")
                        }

                        // Obtém o último ID da lista de endereços
                        val ultimoEnderecoId = enderecosId.last()
                        Log.d("EnderecoID ultimoEnderecoID", "ID do endereço ultimoEnderecoId: ${ultimoEnderecoId}")

                        // Cria o objeto usuário
                        usuario = Usuario(
                            nome = nome,
                            experiencias = experiencias,
                            academicas = academicas,
                            email = email,
                            senha = senha,
                            tipo = tipo,
                            telefone = telefone,
                            areas = areaSelecionada,
                            endereco = ultimoEnderecoId
                        )

                        // Chama a função para cadastrar o usuário
                        cadastrarUsuario(
                            usuario,
                            onSuccess = {
                                navController.navigate("home")
                            },
                            onFailure = { throwable ->
                                // Trate a falha do cadastro aqui, por exemplo, exibindo uma mensagem de erro
                                println("Falha no cadastro do usuário: ${throwable.message}")
                            }
                        )

                        // Navega para a tela "home" após o cadastro
                        navController.navigate("home")
                    }
                }
            },
            colors = ButtonDefaults.buttonColors(Color.Transparent),
            modifier = Modifier
                .width(270.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(Color(0xFF6AD9BE), Color(0xFF17AE8A)),
                        startX = 0f,
                        endX = 900f
                    ),
                    shape = RoundedCornerShape(10.dp)
                )
        ) {
            Text(
                text = "ENVIAR",
                fontSize = 16.sp,
                color = Color.White
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}

private fun searchCep(cep: String, onResult: (Endereco?) -> Unit) {
    val call = RetrofitFactory().getCepService().getEnderecoByCep(cep = cep)
    call.enqueue(object : Callback<Endereco> {
        override fun onResponse(call: Call<Endereco>, response: Response<Endereco>) {
            if (response.isSuccessful) {
                val endereco = response.body()
                println(response.body())
                onResult(endereco)
            } else {
                onResult(null)
            }
        }

        override fun onFailure(call: Call<Endereco>, t: Throwable) {
            onResult(null)
        }
    })
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewFormCadastro() {
    val navController = rememberNavController()
    Box(modifier = Modifier.fillMaxSize()) {
        FormCadastro(navController = navController)
    }
}