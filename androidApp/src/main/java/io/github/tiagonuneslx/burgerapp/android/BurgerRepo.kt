package io.github.tiagonuneslx.burgerapp.android

import io.github.tiagonuneslx.burgerapp.R
import io.github.tiagonuneslx.burgerapp.android.db.dao.BurgerDao
import io.github.tiagonuneslx.burgerapp.android.db.entity.Burger
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BurgerRepo @Inject constructor(private val burgerDao: BurgerDao) {

    suspend fun prepopulateDatabase() {
        burgerDao.insertAll(
            Burger(
                name = "Beef Burger",
                description = "Onion with cheese",
                price = 18f,
                thumbnailResourceId = R.drawable.beef_burger_thumbnail
            ),
            Burger(
                name = "Chicken Burger",
                description = "Cheese with chicken",
                price = 12f,
                thumbnailResourceId = R.drawable.chicken_burger_thumbnail
            ),
            Burger(
                name = "Classic Burger",
                description = "Beef with lettuce",
                price = 24f,
                thumbnailResourceId = R.drawable.classic_burger_thumbnail
            ),
            Burger(
                name = "Grilled Burger",
                description = "Grilled chicken",
                price = 14f,
                thumbnailResourceId = R.drawable.grilled_burger_thumbnail
            )
        )
    }

    fun getAll(): Flow<List<Burger>> = burgerDao.getAll()
}