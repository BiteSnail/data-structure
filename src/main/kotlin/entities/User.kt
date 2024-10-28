package org.example.entities

import java.time.LocalDateTime

class User(
    val id: Long,
    val name: String,
    val createAt: LocalDateTime = LocalDateTime.now(),
    val updateAt: LocalDateTime = LocalDateTime.now(),
) {
}