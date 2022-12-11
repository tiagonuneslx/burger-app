package io.github.tiagonuneslx.burgerapp

actual class BurgersRepo {
    actual fun getBurgers() = listOf(
        Burger(
            0,
            "Beef Burger",
            "Onion with cheese",
            18f,
            R.drawable.beef_burger_thumbnail
        ),
        Burger(
            1,
            "Chicken Burger",
            "Cheese with chicken",
            12f,
            R.drawable.chicken_burger_thumbnail
        ),
        Burger(
            2,
            "Classic Burger",
            "Beef with lettuce",
            24f,
            R.drawable.classic_burger_thumbnail
        ),
        Burger(
            3,
            "Grilled Burger",
            "Grilled chicken",
            14f,
            R.drawable.grilled_burger_thumbnail
        ),
    )
}