package app.config

import io.ktor.server.application.*
import io.ktor.server.routing.*
import presentation.routes.helloRoutes
import presentation.routes.userRoutes

fun Application.configureRouting() {
    routing {
        helloRoutes()
        userRoutes()
    }
}
