package com.example.webflux.anwebflux

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
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

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun save(@RequestBody user: User): Mono<Void> {
        users.add(user)
        return Mono.empty()
    }


    val users = mutableSetOf(
        User(id = "user1@gmail.com"),
        User(id = "user2@gmail.com")
    )


    class User(val id: String)
}

