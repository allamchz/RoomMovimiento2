package cr.ac.una.roommovimiento.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import cr.ac.una.roommovimiento.R

import cr.ac.una.roommovimiento.entity.Movimiento

class MovimientoAdapter(context: Context, movimientos: List<Movimiento>) :
    ArrayAdapter<Movimiento>(context, 0, movimientos) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        }

        val movimiento = getItem(position)

        val fechaTextView = view!!.findViewById<TextView>(R.id.fecha)
        val tipoTextView = view.findViewById<TextView>(R.id.tipo)
        val montoTextView = view.findViewById<TextView>(R.id.monto)

        fechaTextView.text = movimiento!!.fecha.toString()
        tipoTextView.text = movimiento.tipo.toString()
        montoTextView.text = movimiento.monto.toString()

        return view
    }
}