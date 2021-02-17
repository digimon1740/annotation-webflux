package com.example.webflux.anwebflux

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/users")
class Controller(
    val service: Service
) {

    @GetMapping
    fun getAll(): Flux<User> =
        service.getAll()

    @GetMapping("/{id}")
    fun get(@PathVariable("id") id: String): Mono<User> =
        service.getUser(id)

}