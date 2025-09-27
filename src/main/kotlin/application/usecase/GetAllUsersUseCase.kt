package application.usecase

import domain.model.User
import domain.repository.UserRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface GetAllUsersUseCase {
    suspend operator fun invoke(): List<User>
}

class GetAllUsersUseCaseImpl(
    private val repository: UserRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
) : GetAllUsersUseCase {
    override suspend fun invoke(): List<User> = withContext(dispatcher) {
        repository.getAll()
    }
}
