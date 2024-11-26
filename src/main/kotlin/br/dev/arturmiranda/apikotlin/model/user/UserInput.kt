package br.dev.arturmiranda.apikotlin.model.user

import jakarta.validation.constraints.NotBlank

data class UserInput(

    @NotBlank(message = "First name is required")
    val firstName: String,

    @NotBlank(message = "Last name is required")
    val lastName: String,

    @NotBlank(message = "Username is required")
    val username: String,

    @NotBlank(message = "Password is required")
    val password: String
)
