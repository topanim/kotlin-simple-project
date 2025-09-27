package application.usecase

import domain.repository.UserRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface DeleteUserUseCase {
    suspend operator fun invoke(params: Params): Boolean
    data class Params(val id: String)
}

class DeleteUserUseCaseImpl(
    private val repository: UserRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
) : DeleteUserUseCase {
    override suspend fun invoke(params: DeleteUserUseCase.Params): Boolean = withContext(dispatcher) {
        repository.delete(params.id)
    }
}
