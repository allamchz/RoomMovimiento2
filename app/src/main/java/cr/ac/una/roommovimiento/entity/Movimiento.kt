package cr.ac.una.roommovimiento.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*


@Entity
data class Movimiento(
    @PrimaryKey(autoGenerate = true) val id: Long?,
    val monto: Double,
    val tipo: String,
    val fecha: Date
)