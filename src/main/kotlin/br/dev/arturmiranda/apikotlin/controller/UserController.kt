package br.dev.arturmiranda.apikotlin.controller

import br.dev.arturmiranda.apikotlin.model.user.UserInput
import br.dev.arturmiranda.apikotlin.model.user.UserOutput
import br.dev.arturmiranda.apikotlin.service.UserService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@Tag(name = "User", description = "User operations")
@RequestMapping("/user")
class UserController(private val userService : UserService) {

    @Operation(summary = "Create a new user", description = "Create a new user in the system")
    @PostMapping
    fun createUser(@RequestBody @Valid userInput: UserInput): ResponseEntity<UserInput> {
        userService.create(userInput)

        return ResponseEntity.status(201).body(userInput)
    }

    @Operation(summary = "Get all users", description = "Get all users in the system")
    @GetMapping
    fun getUsers(): ResponseEntity<List<UserOutput>> {
        val users = userService.findAll()

        return ResponseEntity.ok(users)
    }

    @Operation(summary = "Delete user by id", description = "Delete user by id in the system")
    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: Long): ResponseEntity<Unit> {
        userService.delete(id)

        return ResponseEntity.noContent().build()
    }

    @Operation(summary = "Update user by id", description = "Update user by id in the system")
    @PutMapping("/{id}")
    fun updateUser(@PathVariable id: Long, @RequestBody @Valid userInput: UserInput): ResponseEntity<UserInput> {
        userService.update(id, userInput)

        return ResponseEntity.ok(userInput)
    }
}
