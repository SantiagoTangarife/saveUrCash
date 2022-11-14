package co.edu.udea.analisis.saveUr.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import co.edu.udea.analisis.saveUr.Pago
import co.edu.udea.analisis.saveUr.R
import kotlinx.android.synthetic.main.item_pago.view.*

class PagosAdapter(private val mContext: Context, private val ListaPagos:List<Pago> ):
    ArrayAdapter<Pago>(mContext,0,ListaPagos) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout= LayoutInflater.from(mContext).inflate(R.layout.item_pago,parent,false)

        val factura=ListaPagos[position]

        layout.nameP.text=factura.Amigo

        return layout
    }
}