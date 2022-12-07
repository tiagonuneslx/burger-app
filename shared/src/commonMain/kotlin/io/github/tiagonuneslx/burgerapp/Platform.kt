package io.github.tiagonuneslx.burgerapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform