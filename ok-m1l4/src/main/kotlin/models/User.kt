package models

import java.time.LocalDateTime
import java.util.*

enum class Action {
    READ,
    DELETE,
    WRITE,
    UPDATE,
    CREATE
}

data class User(
    val id: UserId,

    val firstName: String,
    val secondName: String,
    val lastName: String,

    val available: List<LocalDateTime>,
    val email: Email,
    val phone: Phone,

    val actions: Set<Action>
)

@JvmInline
value class UserId(val id: String) {
    companion object {
        val NONE = UserId("")
        fun random() = UserId(UUID.randomUUID().toString())
    }
}

@JvmInline
value class Email(val email: String) {
    companion object {
        val NONE = Email("")
        fun random() = UUID.randomUUID().toString()
    }
}

@JvmInline
value class Phone(val phone: String) {
    companion object {
        val NONE = Phone("")
        fun random() = UUID.randomUUID().toString()
    }
}