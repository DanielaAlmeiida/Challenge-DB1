package br.com.fiap.sowa.model

data class Endereco (
    val id: String?,
    val cep: String?,
    var logradouro: String?,
    var bairro: String?,
    var localidade: String?,
    var uf: String?
)