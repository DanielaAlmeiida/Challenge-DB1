package br.com.fiap.sowa.model

data class UserEndereco(
    val id: String,
    val logradouro: String?,
    val bairro: String?,
    val cidade: String?,
    val uf: String?,
    val cep: String?
)