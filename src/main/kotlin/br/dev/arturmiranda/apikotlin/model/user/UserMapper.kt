package br.dev.arturmiranda.apikotlin.model.user

import java.time.LocalDateTime

class UserMapper {
    companion object {
        fun toUser(userInput: UserInput): User {
            return User(
                firstName = userInput.firstName,
                lastName = userInput.lastName,
                username = userInput.username,
                password = userInput.password,
                createdAt = LocalDateTime.now(),
                updatedAt = LocalDateTime.now()
            )
        }

        fun toUserOutput(user: User): UserOutput {
            return UserOutput(
                id = user.id!!,
                firstName = user.firstName,
                lastName = user.lastName,
                username = user.username,
            )
        }
    }
}
