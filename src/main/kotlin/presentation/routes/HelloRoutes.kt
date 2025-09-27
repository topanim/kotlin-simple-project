package presentation.routes

import io.ktor.http.HttpStatusCode
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.routing.route

fun Route.helloRoutes() {
    route("/") {
        get {
            call.respond(
                HttpStatusCode.OK,
                mapOf(
                    "message" to "🚀 Welcome to My Ktor API!",
                    "status" to "success",
                    "docs" to "TODO"
                )
            )
        }
    }
}