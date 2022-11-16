package co.edu.udea.analisis.saveUr

import android.widget.ProgressBar
import co.edu.udea.analisis.saveUr.Interfaces.IEstado
import co.edu.udea.analisis.saveUr.States.Aceptable
import co.edu.udea.analisis.saveUr.States.Critico
import co.edu.udea.analisis.saveUr.States.Grave
import co.edu.udea.analisis.saveUr.States.Normal
import co.edu.udea.analisis.saveUr.StrategiesCarga.PagosLoader
import co.edu.udea.analisis.saveUr.StrategiesCarga.TransaccionLoader
import co.edu.udea.analisis.saveUr.StrategiesGuardar.IngresoSaver
import co.edu.udea.analisis.saveUr.StrategiesGuardar.TransaccionSaver

class Fachada() {
    var estadoNormal: IEstado = Normal(this)
    var estadoAceptable: IEstado = Aceptable(this)
    var estadoGrave: IEstado = Grave(this)
    var estadocritico: IEstado = Critico(this)
    val saver: TransaccionSaver = TransaccionSaver(IngresoSaver())
    val loader: TransaccionLoader = TransaccionLoader(PagosLoader())
    var state: IEstado = estadoNormal


    private fun Fachada(): Fachada {return instancia}

    companion object {
        private var instancia: Fachada = Fachada()
        fun getInstancia(): Fachada {
            return instancia
        }
    }

    fun CambiarEstado(estado: IEstado){
        state = estado
    }

    fun ActualizarBarra(registrosInEg: ArrayList<Float>, progressBar2: ProgressBar, CargarDbAh:List<String>){
        state.balance(registrosInEg,progressBar2,CargarDbAh)
        state.color(progressBar2)
    }

    fun guardarIngreso(ingreso: Ingreso, ruta: String?){
        saver.guardarIngreso(ingreso,ruta)
    }

    fun guardarEgreso(egreso: Egreso, ruta: String?){
        saver.guardarEgreso(egreso,ruta)
    }

    fun guardarFactura(factura: Factura, ruta: String?){
        saver.guardarFactura(factura,ruta)
    }

    fun cargarFacturas(ruta: String?): ArrayList<Factura> {
        return loader.cargarFacturas(ruta)
    }

    fun cargarPagos(ruta: String?): ArrayList<Pago> {
        return loader.cargarPagos(ruta)
    }
}