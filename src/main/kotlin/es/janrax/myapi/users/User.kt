package es.janrax.myapi.users

import jakarta.validation.constraints.Past
import jakarta.validation.constraints.Size
import java.time.LocalDate

data class User(
    var id: Int = 0,

    @field:Size(min = 2, message = "minimo 2 caracteres")
    val name: String,

    @field:Past(message = "tiene que ser fecha pasada, champ!")
    val birthDate: LocalDate,
)
