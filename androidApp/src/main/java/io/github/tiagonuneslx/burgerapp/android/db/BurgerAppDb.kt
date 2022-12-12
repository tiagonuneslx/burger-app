package io.github.tiagonuneslx.burgerapp.android.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import io.github.tiagonuneslx.burgerapp.android.db.dao.BurgerDao
import io.github.tiagonuneslx.burgerapp.android.db.entity.Burger

@Database(entities = [Burger::class], version = 1, exportSchema = false)
abstract class BurgerAppDb : RoomDatabase() {

    abstract fun burgerDao(): BurgerDao

    companion object {
        fun getDatabase(context: Context) =
            Room.databaseBuilder(context, BurgerAppDb::class.java, "burger-app.db")
                /**
                 * 3.1.2. Play with the Burgers data natively using static database
                 */
                .createFromAsset("burger-app.db")
                .build()
    }
}