package br.com.fiap.sowa.model

data class UsuarioHome(
    var nome: String?,
    var experiencias: String?,
    var academicas: String?,
    var email: String?,
    var senha: String?,
    var tipo: String?,
    var telefone: String?,
    var areas: String?,
    var endereco: Endereco?
)