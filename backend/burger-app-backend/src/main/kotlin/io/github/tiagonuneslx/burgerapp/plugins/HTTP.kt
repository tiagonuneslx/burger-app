package io.github.tiagonuneslx.burgerapp.plugins

import io.ktor.http.*
import io.ktor.server.plugins.compression.*
import io.ktor.server.plugins.defaultheaders.*
import io.ktor.server.plugins.swagger.*
import io.ktor.server.plugins.openapi.*
import io.ktor.server.application.*
import io.ktor.server.plugins.cors.routing.*
import io.ktor.server.response.*
import io.ktor.server.request.*

fun Application.configureHTTP() {
    install(Compression) {
        gzip {
            priority = 1.0
        }
        deflate {
            priority = 10.0
            minimumSize(1024)
        }
    }
    install(DefaultHeaders) {
        header("X-Engine", "Ktor")
    }
    install(CORS) {
        anyHost()
        allowHeader(HttpHeaders.ContentType)
    }
}
