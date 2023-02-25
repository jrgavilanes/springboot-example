package es.janrax.myapi.users

import jakarta.validation.constraints.Past
import jakarta.validation.constraints.Size
import java.time.LocalDate

data class User(
    var id: Int = 0,

    @field:Size(min = 2, message = "name must have 2 characters at least")
    val name: String,

    @field:Past(message = "bithdate must be in the past")
    val birthDate: LocalDate,
)
