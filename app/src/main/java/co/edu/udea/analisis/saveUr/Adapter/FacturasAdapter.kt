package co.edu.udea.analisis.saveUr.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import co.edu.udea.analisis.saveUr.Factura
import co.edu.udea.analisis.saveUr.R
import kotlinx.android.synthetic.main.item_factura.view.*

class FacturasAdapter(private val mContext:Context,private val ListaFacturas:List<Factura> ):ArrayAdapter<Factura>(mContext,0,ListaFacturas) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout= LayoutInflater.from(mContext).inflate(R.layout.item_factura,parent,false)

        val factura=ListaFacturas[position]

        layout.name.text=factura.Titulo
        layout.date.text=factura.Fecha
        layout.valorPagar.text= "$${factura.Costo}"
        layout.cuotasP.text="${factura.Cuota}"
        layout.imagenF.setImageResource(factura.Imagen)
        return layout
    }
}