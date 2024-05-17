package br.com.fiap.sowa.service

import br.com.fiap.sowa.model.Endereco
import br.com.fiap.sowa.model.Usuario
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface UsuarioService {

    @GET("usuarios/")
    fun getUsuarios(): Call<List<Usuario>>

    @GET("escolas/")
    fun getUsuariosEscolas(): Call<List<Usuario>>

    @POST("endereco/")
    fun postEndereco(@Body endereco: Endereco): Call<Endereco>
}