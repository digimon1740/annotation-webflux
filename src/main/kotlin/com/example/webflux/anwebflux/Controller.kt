package com.example.webflux.anwebflux

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/users")
class Controller {

    @GetMapping
    fun getAll(): Flux<User> =
        Flux.fromIterable(users)

    @GetMapping("/{id}")
    fun get(@PathVariable("id") id: String): Mono<User> =
        Mono.justOrEmpty(users.findLast { id == it.id })


    val users = listOf(
        User(id = "user1@gmail.com"),
        User(id = "user2@gmail.com")
    )


    class User(val id: String)
}

