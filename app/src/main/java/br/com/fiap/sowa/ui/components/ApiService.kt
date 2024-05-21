package br.com.fiap.sowa.ui.components

import android.util.Log
import br.com.fiap.sowa.model.Endereco
import br.com.fiap.sowa.model.UserEndereco
import kotlinx.coroutines.CoroutineScope
import br.com.fiap.sowa.model.Usuario
import br.com.fiap.sowa.model.UsuarioId
import br.com.fiap.sowa.service.RetrofitFactoryUser
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun searchUsers(onResult: (List<Usuario>?) -> Unit) {
    val call = RetrofitFactoryUser().getUsuarioService().getUsuarios()
    call.enqueue(object : Callback<List<Usuario>> {

        override fun onResponse(call: Call<List<Usuario>>, response: Response<List<Usuario>>) {
            if (response.isSuccessful) {
                val usuarios = response.body()
                if (usuarios != null) {
                    onResult(usuarios)
                } else {
                    onResult(emptyList())
                }
            } else {
                onResult(emptyList())
            }
        }

        override fun onFailure(call: Call<List<Usuario>>, t: Throwable) {
            onResult(emptyList())
        }
    })
}

fun cadastrarEndereco(endereco: Endereco, onSuccess: () -> Unit, onFailure: (Throwable) -> Unit) {
    val call = RetrofitFactoryUser().getUsuarioService().postEndereco(endereco)
    call.enqueue(object : Callback<Endereco> {
        override fun onResponse(call: Call<Endereco>, response: Response<Endereco>) {
            if (response.isSuccessful) {
                onSuccess()
            } else {
                onFailure(Exception("Erro ao cadastrar endereço: ${response.message()}"))
            }
        }

        override fun onFailure(call: Call<Endereco>, t: Throwable) {
            onFailure(t)
        }
    })
}

fun cadastrarUsuario(usuario: Usuario, onSuccess: () -> Unit, onFailure: (Throwable) -> Unit) {
    val call = RetrofitFactoryUser().getUsuarioService().postUsuario(usuario)
    call.enqueue(object : Callback<Usuario> {
        override fun onResponse(call: Call<Usuario>, response: Response<Usuario>) {
            if (response.isSuccessful) {
                Log.d("CadastroUsuario", "Usuário cadastrado com sucesso: ${response.body()}")
                onSuccess()
            } else {
                Log.e("CadastroUsuario", "Erro ao cadastrar usuário: ${response.message()}")
                onFailure(Exception("Erro ao cadastrar usuário: ${response.message()}" + "Erro ao cadastrar usuário: ${response}"
                ))
            }
        }
        override fun onFailure(call: Call<Usuario>, t: Throwable) {
            onFailure(t)
        }
    })
}

fun searchEnderecos(onResult: (List<UserEndereco>?) -> Unit) {
    val call = RetrofitFactoryUser().getUsuarioService().getEnderecos()
    call.enqueue(object : Callback<List<UserEndereco>> {

        override fun onResponse(call: Call<List<UserEndereco>>, response: Response<List<UserEndereco>>) {
            if (response.isSuccessful) {
                val endereco = response.body()
                if (endereco != null) {
                    onResult(endereco)
                } else {
                    onResult(emptyList())
                }
            } else {
                onResult(emptyList())
            }
        }

        override fun onFailure(call: Call<List<UserEndereco>>, t: Throwable) {
            onResult(emptyList())
        }
    })
}

fun getUserById(_id: String, onResult: (UsuarioId?) -> Unit) {
    val call = RetrofitFactoryUser().getUsuarioService().getUsuarioId(_id)
    call.enqueue(object : Callback<UsuarioId> {

        override fun onResponse(call: Call<UsuarioId>, response: Response<UsuarioId>) {
            if (response.isSuccessful) {
                val usuario = response.body()
                onResult(usuario)
            } else {
                onResult(null)
            }
        }

        override fun onFailure(call: Call<UsuarioId>, t: Throwable) {
            onResult(null)
        }
    })
}

fun searchUsersId(onResult: (List<UsuarioId>?) -> Unit) {
    val call = RetrofitFactoryUser().getUsuarioService().getUsuariosId()
    call.enqueue(object : Callback<List<UsuarioId>> {

        override fun onResponse(call: Call<List<UsuarioId>>, response: Response<List<UsuarioId>>) {
            if (response.isSuccessful) {
                val usuarios = response.body()
                if (usuarios != null) {
                    onResult(usuarios)
                } else {
                    onResult(emptyList())
                }
            } else {
                onResult(emptyList())
            }
        }

        override fun onFailure(call: Call<List<UsuarioId>>, t: Throwable) {
            onResult(emptyList())
        }
    })
}