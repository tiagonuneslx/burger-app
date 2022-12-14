package io.github.tiagonuneslx.burgerapp

import io.ktor.server.application.*
import io.github.tiagonuneslx.burgerapp.plugins.*

fun main(args: Array<String>): Unit =
    io.ktor.server.cio.EngineMain.main(args)

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {
    configureHTTP()
    configureSerialization()
    configureMonitoring()
    configureRouting()
}
