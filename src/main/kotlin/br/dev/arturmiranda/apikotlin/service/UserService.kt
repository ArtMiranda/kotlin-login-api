package br.dev.arturmiranda.apikotlin.service

import br.dev.arturmiranda.apikotlin.model.user.User
import br.dev.arturmiranda.apikotlin.model.user.UserInput
import br.dev.arturmiranda.apikotlin.model.user.UserMapper
import br.dev.arturmiranda.apikotlin.model.user.UserOutput
import br.dev.arturmiranda.apikotlin.repository.UserRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class UserService(private val userRepository : UserRepository, private val passwordEncoder: PasswordEncoder) {

    fun create(userInput: UserInput): UserOutput {
        val hashedPassword = passwordEncoder.encode(userInput.password)

        val user = User(
            firstName = userInput.firstName,
            lastName = userInput.lastName,
            username = userInput.username,
            password = hashedPassword,
            createdAt = LocalDateTime.now(),
            updatedAt = LocalDateTime.now()
        )

        val userSaved = userRepository.save(user)
        return UserMapper.toUserOutput(userSaved)
    }

    fun findAll(): List<UserOutput> {
        val users = userRepository.findAll()
        return users.map { UserMapper.toUserOutput(it) }
    }

    fun delete(id: Long) {
        val user = userRepository.findById(id).orElseThrow { throw Exception("User not found") }
        userRepository.delete(user)
    }

    fun update(id: Long, userInput: UserInput) {
        val user = userRepository.findById(id).orElseThrow { throw Exception("User not found") }
        user.firstName = userInput.firstName
        user.lastName = userInput.lastName
        user.username = userInput.username
        user.password = userInput.password
        user.updatedAt = LocalDateTime.now()
        userRepository.save(user)

    }
}