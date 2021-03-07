package com.example.webflux.anwebflux

import org.springframework.stereotype.Service
import reactor.kotlin.core.publisher.toFlux
import reactor.kotlin.core.publisher.toMono

@Service
class Service {

    fun getAll() = users.toFlux()

    fun get(id: String) = users.findLast { id == it.id }.toMono()

    fun add(user: User) {
        users.add(user)
    }
}
