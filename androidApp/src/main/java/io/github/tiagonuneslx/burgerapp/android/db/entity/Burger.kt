package io.github.tiagonuneslx.burgerapp.android.db.entity

import androidx.annotation.DrawableRes
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Fts4
import androidx.room.PrimaryKey
import io.github.tiagonuneslx.burgerapp.R

@Entity
data class Burger(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "rowid") val id: Int = 0,
    val name: String,
    val description: String,
    val price: Float,
    @DrawableRes
    val thumbnailResourceId: Int,
) {
    companion object {
        val samples = listOf(
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
            )
        )
    }
}