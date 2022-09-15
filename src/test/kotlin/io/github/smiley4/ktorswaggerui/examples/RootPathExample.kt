package io.github.smiley4.ktorswaggerui.examples

import io.github.smiley4.ktorswaggerui.SwaggerUI
import io.github.smiley4.ktorswaggerui.dsl.get
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.application.install
import io.ktor.server.netty.EngineMain
import io.ktor.server.response.respondText
import io.ktor.server.routing.routing


fun main(args: Array<String>): Unit = EngineMain.main(args)

fun Application.module() {

    install(SwaggerUI) {
        swagger {
            swaggerUrl = "swagger-ui"
            forwardRoot = true
        }
        info {
            title = "Example API"
            version = "latest"
            description = "Example api for testing"
        }
        server {
            url = "http://localhost:8080"
            description = "Development server"
        }
    }

    routing {
        get("hello", {
            description = "Simple 'Hello World'- Route"
            response {
                HttpStatusCode.OK to {
                    description = "Successful Response"
                }
            }
        }) {
            call.respondText("Hello World!")
        }
    }
}

