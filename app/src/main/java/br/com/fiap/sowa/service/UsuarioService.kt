package br.com.fiap.sowa.service

import br.com.fiap.sowa.model.Endereco
import br.com.fiap.sowa.model.UserEndereco
import br.com.fiap.sowa.model.Usuario
import br.com.fiap.sowa.model.UsuarioId
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface UsuarioService {

    @GET("usuarios/")
    fun getUsuarios(): Call<List<Usuario>>

    @GET("usuarios/")
    fun getUsuariosId(): Call<List<UsuarioId>>

    @GET("usuario/{id}")
    fun getUsuarioId(@Path("id") id: String): Call<UsuarioId>

    @GET("enderecos/")
    fun getEnderecos(): Call<List<UserEndereco>>

    @POST("usuario/")
    fun postUsuario(@Body usuario: Usuario): Call<Usuario>

    @POST("endereco/")
    fun postEndereco(@Body endereco: Endereco): Call<Endereco>


}