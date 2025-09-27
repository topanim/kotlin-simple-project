package domain.model

import kotlinx.serialization.Serializable

@Serializable
data class UserInput(
    val name: String,
    val email: String
)
