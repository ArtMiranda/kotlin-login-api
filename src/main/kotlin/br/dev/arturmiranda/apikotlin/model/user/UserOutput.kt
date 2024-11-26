package br.dev.arturmiranda.apikotlin.model.user

data class UserOutput(
    val id: Long,
    val firstName: String,
    val lastName: String,
    val username: String,
)
