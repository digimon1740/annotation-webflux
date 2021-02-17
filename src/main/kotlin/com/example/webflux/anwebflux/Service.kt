package com.example.webflux.anwebflux

import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

class User(val id: String)

@Service
class Service {

    val users = listOf(
        User(id = "user1@gmail.com"),
        User(id = "user2@gmail.com")
    )

    fun getUser(id: String) =
        Mono.justOrEmpty(users.findLast { id == it.id })

    fun getAll() =
        Flux.fromIterable(users)
}