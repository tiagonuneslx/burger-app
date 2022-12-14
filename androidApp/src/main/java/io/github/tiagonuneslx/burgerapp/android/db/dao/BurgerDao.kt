package io.github.tiagonuneslx.burgerapp.android.db.dao

import androidx.room.*
import io.github.tiagonuneslx.burgerapp.android.db.entity.Burger
import kotlinx.coroutines.flow.Flow

@Dao
interface BurgerDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg burgers: Burger)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(burgers: List<Burger>)

    @Delete
    suspend fun delete(user: Burger)

    @Update
    suspend fun update(vararg burgers: Burger)

    @Query("SELECT * FROM Burger")
    fun getAll(): Flow<List<Burger>>

    @Query("SELECT * FROM Burger WHERE rowid = :id")
    fun get(id: Int): Flow<Burger?>
}