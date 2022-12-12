package io.github.tiagonuneslx.burgerapp.android

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.github.tiagonuneslx.burgerapp.android.db.BurgerAppDb
import io.github.tiagonuneslx.burgerapp.android.db.dao.BurgerDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
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
}

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class AppCoroutineScope