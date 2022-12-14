package io.github.tiagonuneslx.burgerapp.android.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
@Entity
data class Burger(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "rowid") val id: Int = 0,
    val name: String,
    val description: String,
    val price: Float,
    val thumbnailUrl: String,
) {
    companion object {
        val samples = listOf(
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
}