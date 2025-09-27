package application.usecase

import domain.model.User
import domain.repository.UserRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface GetUserUseCase {
    suspend operator fun invoke(params: Params): User?
    data class Params(val id: String)
}

class GetUserUseCaseImpl(
    private val repository: UserRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
) : GetUserUseCase {
    override suspend fun invoke(params: GetUserUseCase.Params): User? = withContext(dispatcher) {
        repository.getById(params.id)
    }
}
