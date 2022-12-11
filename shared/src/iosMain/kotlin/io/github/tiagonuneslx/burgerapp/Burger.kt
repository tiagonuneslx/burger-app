package io.github.tiagonuneslx.burgerapp

actual class Burger(
    actual val id: Int,
    actual val name: String,
    actual val description: String,
    actual val price: Float,
    val thumbnailName: String,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (this::class != other?.let { it::class }) return false

        other as Burger

        if (id != other.id) return false
        if (name != other.name) return false
        if (description != other.description) return false
        if (price != other.price) return false
        if (thumbnailName != other.thumbnailName) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + description.hashCode()
        result = 31 * result + price.hashCode()
        result = 31 * result + thumbnailName.hashCode()
        return result
    }

    override fun toString(): String {
        return "Burger(id=$id, name='$name', description='$description', price=$price, thumbnailName='$thumbnailName')"
    }
}