package cr.ac.una.roommovimiento.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import cr.ac.una.roommovimiento.entity.Movimiento


@Dao
interface UbicacionDao {
    @Insert
    fun insert(entity: Movimiento)

    @Query("SELECT * FROM movimiento")
    fun getAll(): List<Movimiento?>?
}