package com.example.gateway.dto.response

import java.time.LocalDateTime

data class UserDto(
    val id: Long?,
    val email: String?,
    val roles: List<String>,
    val name: String?,
    val lastname: String?,
    val verifiedAt: LocalDateTime? = null
)
