package br.com.fiap.sowa.service

import br.com.fiap.sowa.model.Usuario
import retrofit2.Call
import retrofit2.http.GET

interface UsuarioService {

    @GET("usuarios/")
    fun getUsuarios(): Call<List<Usuario>>

    @GET("escolas/")
    fun getUsuariosEscolas(): Call<List<Usuario>>

}