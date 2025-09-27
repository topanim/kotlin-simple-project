package domain.repository

import domain.model.User

interface UserRepository {
    fun create(user: User)
    fun getAll(): List<User>
    fun getById(id: String): User?
    fun update(user: User): Boolean
    fun delete(id: String): Boolean
}
