package di

import application.usecase.*
import domain.repository.UserRepository
import infrastructure.repository.UserRepositoryImpl
import org.koin.dsl.module

val appModule = module {
    //region Repositories

    single<UserRepository> { UserRepositoryImpl() }

    //endregion Repositories

    //region Use cases

    single<CreateUserUseCase> { CreateUserUseCaseImpl(repository = get()) }
    single<DeleteUserUseCase> { DeleteUserUseCaseImpl(repository = get()) }
    single<GetAllUsersUseCase> { GetAllUsersUseCaseImpl(repository = get()) }
    single<GetUserUseCase> { GetUserUseCaseImpl(repository = get()) }
    single<UpdateUserUseCase> { UpdateUserUseCaseImpl(repository = get()) }

    //endregion Use cases
}
