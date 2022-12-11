package io.github.tiagonuneslx.burgerapp

actual class BurgersRepo {
    actual fun getBurgers() = listOf(
        Burger(
            0,
            "Beef Burger",
            "Onion with cheese",
            18f,
            "BeefBurgerThumbnail"
        ),
        Burger(
            1,
            "Chicken Burger",
            "Cheese with chicken",
            12f,
            "ChickenBurgerThumbnail"
        ),
        Burger(
            2,
            "Classic Burger",
            "Beef with lettuce",
            24f,
            "ClassicBurgerThumbnail"
        ),
        Burger(
            3,
            "Grilled Burger",
            "Grilled chicken",
            14f,
            "GrilledBurgerThumbnail"
        ),
    )
}