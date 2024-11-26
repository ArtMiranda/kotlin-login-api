package br.dev.arturmiranda.apikotlin.repository

import br.dev.arturmiranda.apikotlin.model.user.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {
    fun findByUsername(username: String): User?
}