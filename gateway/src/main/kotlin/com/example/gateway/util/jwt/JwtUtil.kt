package com.example.gateway.util.jwt

import com.example.gateway.model.User
import com.example.starter.utils.dto.JwtUserDto
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.time.Duration

/**
 * Утилита для работы с JWT-токенами.
 */
@Component
class JwtUtil(
    @Value("\${app.auth.jwt.secret}") private val secret: String,
    @Value("\${app.auth.jwt.expiration}") private val expiration: Duration
) : AbstractTokenUtil(), TokenUtil {

    override fun getExpiration(): Duration {
        return expiration
    }

    override fun getSecret(): String {
        return secret
    }

    override fun getClaims(user: User): Map<String, Any> {
        val jwtUser = JwtUserDto(user.id!!, user.email)
        val claims: MutableMap<String, Any> = HashMap()
        claims["user"] = jwtUser

        return claims
    }
}
