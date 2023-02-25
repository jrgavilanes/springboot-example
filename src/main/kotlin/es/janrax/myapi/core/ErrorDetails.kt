package es.janrax.myapi.core

import java.time.LocalDateTime

data class ErrorDetails(val timestamp: LocalDateTime, val message: String, val detail: String)
