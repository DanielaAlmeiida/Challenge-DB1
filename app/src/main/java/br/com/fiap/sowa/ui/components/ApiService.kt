package br.com.fiap.sowa.ui.components

import kotlinx.coroutines.CoroutineScope
import br.com.fiap.sowa.model.Usuario
import br.com.fiap.sowa.service.RetrofitFactoryUser
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun CoroutineScope.searchUsers(onResult: (List<Usuario>?) -> Unit) {
    val call = RetrofitFactoryUser().getUsuarioService().getUsuariosProffisionais()
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

fun CoroutineScope.searchUsersEscola(onResult: (List<Usuario>?) -> Unit) {
    val call = RetrofitFactoryUser().getUsuarioService().getUsuariosEscolas()
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