package br.com.fiap.sowa.model

data class UserEndereco(
    var _id: String,
    var logradouro: String?,
    var bairro: String?,
    var cidade: String?,
    var uf: String?,
    var cep: String?
)