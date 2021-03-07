package com.example.webflux.anwebflux

class User(val id: String)

val users = mutableSetOf(
    User(id = "user1@gmail.com"),
    User(id = "user2@gmail.com")
)
