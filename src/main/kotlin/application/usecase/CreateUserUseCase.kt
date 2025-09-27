package application.usecase

import domain.model.User
import domain.repository.UserRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface CreateUserUseCase {
    suspend operator fun invoke(params: Params)
    data class Params(val user: User)
}

class CreateUserUseCaseImpl(
    private val repository: UserRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
) : CreateUserUseCase {
    override suspend fun invoke(params: CreateUserUseCase.Params) = withContext(dispatcher) {
        repository.create(params.user)
    }
}
