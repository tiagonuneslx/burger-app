package io.github.tiagonuneslx.burgerapp.android

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.github.tiagonuneslx.burgerapp.android.db.BurgerAppDb
import io.github.tiagonuneslx.burgerapp.android.db.dao.BurgerDao
import io.github.tiagonuneslx.burgerapp.android.network.BurgerApi
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.plugins.resources.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.serialization.json.Json
import javax.inject.Qualifier
import javax.inject.Singleton


/**
 * 4.1. Use a dependency injection framework: Hilt
 */
@Module
@InstallIn(SingletonComponent::class)
object BurgerAppModule {

    @Singleton
    @AppCoroutineScope
    @Provides
    fun providesAppCoroutineScope(): CoroutineScope =
        CoroutineScope(SupervisorJob() + Dispatchers.Default)

    @Singleton
    @Provides
    fun provideBurgerAppDb(
        @ApplicationContext context: Context,
    ): BurgerAppDb = BurgerAppDb.getDatabase(context)

    @Singleton
    @Provides
    fun provideBurgerDao(db: BurgerAppDb): BurgerDao = db.burgerDao()

    @Singleton
    @BurgerRestApiClient
    @Provides
    fun provideBurgerRestApiClient(): HttpClient =
        HttpClient(CIO) {
            install(Logging) {
                level = LogLevel.ALL
            }
            install(Resources)
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                })
            }
            defaultRequest {
                url(BurgerApi.BaseUrl)
            }
        }
}

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class AppCoroutineScope

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class BurgerRestApiClient