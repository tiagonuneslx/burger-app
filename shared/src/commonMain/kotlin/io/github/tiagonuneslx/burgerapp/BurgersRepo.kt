package io.github.tiagonuneslx.burgerapp

/**
 * 3.2.1. Play with the Burgers data using a static list (KMM)
 */
expect class BurgersRepo {
    fun getBurgers(): List<Burger>
}