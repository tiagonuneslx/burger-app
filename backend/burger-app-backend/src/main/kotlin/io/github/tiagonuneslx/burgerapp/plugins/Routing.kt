package io.github.tiagonuneslx.burgerapp.plugins

import io.github.tiagonuneslx.burgerapp.models.Burger
import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.resources.*
import kotlinx.serialization.Serializable
import io.ktor.server.http.content.*
import io.ktor.server.application.*
import io.ktor.server.plugins.openapi.*
import io.ktor.server.plugins.swagger.*
import io.ktor.server.response.*
import io.ktor.server.request.*
import io.ktor.server.resources.*
import io.ktor.server.resources.Resources
import io.ktor.server.routing.get

const val staticPath = "/static"

fun Application.configureRouting() {
    install(Resources)

    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        get<Burgers> {
            call.respond(Burger.all)
        }
        static(staticPath) {
            resources("static")
        }
        swaggerUI(path = "swagger")
    }
}

@Serializable
@Resource("/burgers")
class Burgers
