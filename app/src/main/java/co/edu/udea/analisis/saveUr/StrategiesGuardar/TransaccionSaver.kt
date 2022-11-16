package co.edu.udea.analisis.saveUr.StrategiesGuardar

import co.edu.udea.analisis.saveUr.Egreso
import co.edu.udea.analisis.saveUr.Factura
import co.edu.udea.analisis.saveUr.Ingreso
import co.edu.udea.analisis.saveUr.Interfaces.IDBSaver

class TransaccionSaver(Strategy: IDBSaver) {
    private var strategy = Strategy

    fun setStrategy(Estrategia: IDBSaver){
        this.strategy = Estrategia
    }


    fun guardarFactura(factura: Factura, ruta: String?){
        setStrategy(FacturaSaver())
        strategy.guardar(factura,ruta)
    }

    fun guardarEgreso(egreso: Egreso, ruta: String?){
        setStrategy(EgresoSaver())
        strategy.guardar(egreso,ruta)
    }

    fun guardarIngreso(ingreso: Ingreso, ruta: String?){
        setStrategy(IngresoSaver())
        strategy.guardar(ingreso, ruta)
    }


}