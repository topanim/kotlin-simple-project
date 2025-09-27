package app

import app.config.configureFrameworks
import app.config.configureHTTP
import app.config.configureRouting
import app.config.configureSerialization
import io.ktor.server.application.*
import io.ktor.server.netty.*

fun main(args: Array<String>) {
    EngineMain.main(args)
}

@Suppress("unused")
fun Application.module() {
    configureHTTP()
    configureFrameworks()
    configureSerialization()
    configureRouting()
}
