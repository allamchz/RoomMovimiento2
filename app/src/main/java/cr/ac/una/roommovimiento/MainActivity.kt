package cr.ac.una.roommovimiento

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import androidx.lifecycle.lifecycleScope
import cr.ac.una.roommovimiento.adapter.MovimientoAdapter
import cr.ac.una.roommovimiento.dao.UbicacionDao
import cr.ac.una.roommovimiento.db.AppDatabase
import cr.ac.una.roommovimiento.entity.Movimiento
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.Date

class MainActivity : AppCompatActivity() {
    private lateinit var movimientoDao: UbicacionDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        movimientoDao = AppDatabase.getInstance(this).ubicacionDao()

        val buttonInsert = findViewById<Button>(R.id.buttonInsert)
        buttonInsert.setOnClickListener {
            val entity = Movimiento(
                id = null,
                tipo = "crédito",
                monto = 2.0,
                fecha = Date()
            )
            insertEntity(entity)
        }
        val listView = findViewById<ListView>(R.id.listUbicaciones)
        var ubicaciones: List<Movimiento>


        lifecycleScope.launch {
            withContext(Dispatchers.Default) {
                ubicaciones = movimientoDao.getAll() as List<Movimiento>
                val adapter = MovimientoAdapter(this@MainActivity, ubicaciones)
                listView.adapter = adapter
            }

        }
    }
    private fun insertEntity(entity: Movimiento) {
        lifecycleScope.launch {
            withContext(Dispatchers.Default) {
                movimientoDao.insert(entity)
            }
        }

    }
}