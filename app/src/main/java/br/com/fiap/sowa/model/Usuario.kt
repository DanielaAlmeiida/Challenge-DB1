package br.com.fiap.sowa.model

data class Usuario(
    var nome: String?,
    var email: String?,
    var senha: String?,
    var tipo: String?,
    var telefone: String?,
    var areas: String,
    var endereco: UserEndereco?
)