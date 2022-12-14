package io.github.tiagonuneslx.burgerapp.android

import io.github.tiagonuneslx.burgerapp.R
import io.github.tiagonuneslx.burgerapp.android.db.dao.BurgerDao
import io.github.tiagonuneslx.burgerapp.android.db.entity.Burger
import io.github.tiagonuneslx.burgerapp.android.network.BurgerApi
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BurgerRepo @Inject constructor(
    private val burgerDao: BurgerDao,
    private val burgerApi: BurgerApi
) {

    suspend fun prepopulateDatabase() {
        burgerDao.insertAll(
            Burger(
                1,
                "Beef Burger",
                "Onion with cheese",
                18f,
                "/static/beef_burger_thumbnail.png"
            ),
            Burger(
                2,
                "Chicken Burger",
                "Cheese with chicken",
                12f,
                "/static/chicken_burger_thumbnail.png"
            ),
            Burger(
                3,
                "Classic Burger",
                "Beef with lettuce",
                24f,
                "/static/classic_burger_thumbnail.png"
            ),
            Burger(
                4,
                "Grilled Burger",
                "Grilled chicken",
                14f,
                "/static/grilled_burger_thumbnail.png"
            ),
        )
    }

    fun getAll() = burgerDao.getAll()

    /**
     * 3.1.3. Fetch from network (Android: Ktor Client)
     */
    suspend fun getAllFromNetwork() = burgerApi.getAllBurgers()

    /**
     * 3.1.4. Fetch from network + Caching in database
     */
    suspend fun downloadAll() {
        val burgers = getAllFromNetwork()
        burgerDao.insertAll(burgers)
    }
}