package io.github.tiagonuneslx.burgerapp.android.network

import io.github.tiagonuneslx.burgerapp.android.BurgerRestApiClient
import io.github.tiagonuneslx.burgerapp.android.db.entity.Burger
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.plugins.resources.*
import io.ktor.client.plugins.resources.Resources
import io.ktor.http.*
import io.ktor.resources.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import javax.inject.Inject
import javax.inject.Singleton

/**
 * 3.1.3. Fetch from network (Android: Ktor Client)
 */
@Singleton
class BurgerApi @Inject constructor(
    @BurgerRestApiClient private val client: HttpClient
) {

    suspend fun getAllBurgers() = client.get(Burgers()).body<List<Burger>>()

    @Serializable
    @Resource("/burgers")
    class Burgers

    companion object {
        const val BaseUrl = "http://0.0.0.0:8080"
    }
}