package com.example.webflux.anwebflux

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toFlux
import reactor.kotlin.core.publisher.toMono

@RestController
@RequestMapping("/users")
class Controller {

    @GetMapping
    fun getAll(): Flux<User> = users.toFlux()

    @GetMapping("/{id}")
    fun get(@PathVariable("id") id: String): Mono<User> =
        users.findLast { id == it.id }.toMono()

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun save(@RequestBody user: User): Mono<Void> {
        users.add(user)
        return Mono.empty()
    }


    val users = mutableListOf(
        User(id = "user1@gmail.com"),
        User(id = "user2@gmail.com")
    )


    class User(val id: String)
}
