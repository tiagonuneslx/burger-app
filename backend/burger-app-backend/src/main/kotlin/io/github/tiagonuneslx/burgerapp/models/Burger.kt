package io.github.tiagonuneslx.burgerapp.models

import io.github.tiagonuneslx.burgerapp.plugins.staticPath
import kotlinx.serialization.Serializable

@Serializable
data class Burger(
    val id: Int,
    val name: String,
    val description: String,
    val price: Float,
    val thumbnailUrl: String,
) {
    companion object {
        val all = listOf(
            Burger(
                1,
                "Beef Burger",
                "Onion with cheese",
                18f,
                "$staticPath/beef_burger_thumbnail.png"
            ),
            Burger(
                2,
                "Chicken Burger",
                "Cheese with chicken",
                12f,
                "$staticPath/chicken_burger_thumbnail.png"
            ),
            Burger(
                3,
                "Classic Burger",
                "Beef with lettuce",
                24f,
                "$staticPath/classic_burger_thumbnail.png"
            ),
            Burger(
                4,
                "Grilled Burger",
                "Grilled chicken",
                14f,
                "$staticPath/grilled_burger_thumbnail.png"
            ),
        )
    }
}