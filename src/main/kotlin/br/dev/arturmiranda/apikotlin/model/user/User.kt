package br.dev.arturmiranda.apikotlin.model.user

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "users")
data class User(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false, name = "first_name")
    var firstName: String,

    @Column(nullable = false, name = "last_name")
    var lastName: String,

    @Column(nullable = false, name = "username")
    var username: String,

    @Column(nullable = false, name = "password")
    var password: String,

    @Column(nullable = false, name = "created_at")
    val createdAt: LocalDateTime,

    @Column(nullable = false, name = "updated_at")
    var updatedAt: LocalDateTime
)
