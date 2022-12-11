package io.github.tiagonuneslx.burgerapp

import androidx.annotation.DrawableRes

actual class Burger(
    actual val id: Int,
    actual val name: String,
    actual val description: String,
    actual val price: Float,
    @DrawableRes
    val thumbnailResourceId: Int,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Burger

        if (id != other.id) return false
        if (name != other.name) return false
        if (description != other.description) return false
        if (price != other.price) return false
        if (thumbnailResourceId != other.thumbnailResourceId) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + name.hashCode()
        result = 31 * result + description.hashCode()
        result = 31 * result + price.hashCode()
        result = 31 * result + thumbnailResourceId
        return result
    }

    override fun toString(): String {
        return "Burger(id=$id, name='$name', description='$description', price=$price, thumbnailResourceId=$thumbnailResourceId)"
    }
}