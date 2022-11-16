package co.edu.udea.analisis.saveUr.StrategiesGuardar

import androidx.appcompat.app.AppCompatActivity
import co.edu.udea.analisis.saveUr.Interfaces.IDBSaver
import co.edu.udea.analisis.saveUr.Transaccion
import java.io.File

class IngresoSaver: IDBSaver, AppCompatActivity() {

    override fun guardar(transaccion: Transaccion, ruta: String?) {
        val outString= transaccion.toString()
        try {
            val miCarpeta = File(ruta, "datos")
            if (!miCarpeta.exists()) {
                miCarpeta.mkdir()
            }
            val ficheroFisico = File(miCarpeta, "datos.txt")
            ficheroFisico.appendText("$outString\n")


        }
        catch (e: Exception) {

                throw Exception()
        }
    }
}