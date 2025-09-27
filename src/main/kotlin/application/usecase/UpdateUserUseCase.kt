package application.usecase

import domain.model.User
import domain.repository.UserRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface UpdateUserUseCase {
    suspend operator fun invoke(params: Params): Boolean
    data class Params(val user: User)
}

class UpdateUserUseCaseImpl(
    private val repository: UserRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
) : UpdateUserUseCase {
    override suspend fun invoke(params: UpdateUserUseCase.Params): Boolean = withContext(dispatcher) {
        repository.update(params.user)
    }
}
