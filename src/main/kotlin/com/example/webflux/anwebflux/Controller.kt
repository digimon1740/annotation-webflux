package com.example.webflux.anwebflux

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/users")
class Controller(
    val service: Service
) {

    @GetMapping
    fun getAll(): Flux<User> = service.getAll()

    @GetMapping("/{id}")
    fun get(@PathVariable("id") id: String): Mono<User> =
        service.get(id)

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun save(@RequestBody user: User): Mono<Void> {
        service.add(user)
        return Mono.empty()
    }
}

