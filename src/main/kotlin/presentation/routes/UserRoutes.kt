package presentation.routes

import application.usecase.*
import domain.model.User
import domain.model.UserInput
import io.ktor.http.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.getKoin
import utils.IdGenerator

fun Route.userRoutes() {
    val createUserUseCase = application.getKoin().get<CreateUserUseCase>()
    val getAllUsersUseCase = application.getKoin().get<GetAllUsersUseCase>()
    val getUserUseCase = application.getKoin().get<GetUserUseCase>()
    val updateUserUseCase = application.getKoin().get<UpdateUserUseCase>()
    val deleteUserUseCase = application.getKoin().get<DeleteUserUseCase>()

    route("/users") {
        post {
            try {
                val input = call.receive<UserInput>()
                val user = User(id = IdGenerator.generate(), name = input.name, email = input.email)
                createUserUseCase.invoke(CreateUserUseCase.Params(user))
                call.respond(status = HttpStatusCode.Created, message = user)
            } catch (e: Exception) {
                e.printStackTrace()
                call.respond(HttpStatusCode.BadRequest, "Invalid request: ${e.message}")
            }
        }

        get {
            val userList = getAllUsersUseCase.invoke()
            call.respond(status = HttpStatusCode.OK, message = userList)
        }

        get("{id}") {
            val id = call.parameters["id"]!!
            val user = getUserUseCase.invoke(GetUserUseCase.Params(id))
            if (user != null) call.respond(status = HttpStatusCode.OK, message = user)
            else call.respondText(status = HttpStatusCode.NotFound, text = "User not found")
        }

        put("{id}") {
            val id = call.parameters["id"]!!
            val input = call.receive<UserInput>()
            val updated =
                updateUserUseCase.invoke(
                    UpdateUserUseCase.Params(User(id = id, name = input.name, email = input.email))
                )
            if (updated) call.respondText(status = HttpStatusCode.OK, text = "User updated")
            else call.respondText(status = HttpStatusCode.NotFound, text = "User not found")
        }

        delete("{id}") {
            val id = call.parameters["id"]!!
            val deleted = deleteUserUseCase.invoke(DeleteUserUseCase.Params(id))
            if (deleted) call.respondText(status = HttpStatusCode.NoContent, text = "User deleted")
            else call.respondText(status = HttpStatusCode.NotFound, text = "User not found")
        }
    }
}
