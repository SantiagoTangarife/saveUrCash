package co.edu.udea.analisis.saveUr.StrategiesCarga

import co.edu.udea.analisis.saveUr.*
import co.edu.udea.analisis.saveUr.Interfaces.IDBLoader
import co.edu.udea.analisis.saveUr.StrategiesGuardar.EgresoSaver
import co.edu.udea.analisis.saveUr.StrategiesGuardar.FacturaSaver
import co.edu.udea.analisis.saveUr.StrategiesGuardar.IngresoSaver


class TransaccionLoader(Strategy: IDBLoader)  {
    private var strategy = Strategy

    fun setStrategy(Estrategia: IDBLoader){
        this.strategy = Estrategia
    }

    fun cargarFacturas(ruta: String?): ArrayList<Factura> {
        setStrategy(FacturaLoader())
        return strategy.cargar(ruta) as ArrayList<Factura>
    }

    fun cargarPagos(ruta: String?): ArrayList<Pago> {
        setStrategy(PagosLoader())
        return strategy.cargar(ruta) as ArrayList<Pago>
    }

}