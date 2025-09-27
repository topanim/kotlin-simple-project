package infrastructure.repository

import domain.model.User
import domain.repository.UserRepository

class UserRepositoryImpl : UserRepository {
    private val users = mutableMapOf<String, User>()

    override fun create(user: User) {
        users[user.id] = user
    }

    override fun getAll(): List<User> = users.values.toList()

    override fun getById(id: String): User? = users[id]

    override fun update(user: User): Boolean {
        return if (users.containsKey(user.id)) {
            users[user.id] = user
            true
        } else false
    }

    override fun delete(id: String): Boolean = users.remove(id) != null
}
