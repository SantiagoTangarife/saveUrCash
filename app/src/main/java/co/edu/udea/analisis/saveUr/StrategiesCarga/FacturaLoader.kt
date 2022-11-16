package co.edu.udea.analisis.saveUr.StrategiesCarga

import androidx.appcompat.app.AppCompatActivity
import co.edu.udea.analisis.saveUr.Factura
import co.edu.udea.analisis.saveUr.Interfaces.IDBLoader
import co.edu.udea.analisis.saveUr.R
import co.edu.udea.analisis.saveUr.Transaccion
import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.InputStreamReader
import java.util.ArrayList

class FacturaLoader: IDBLoader, AppCompatActivity() {

    override fun cargar(ruta:String?) : List<Factura> {
        var texto = ""
        try {
            val miCarpeta = File(ruta, "facturas")//CREO ARCHIVO Ruta
            val ficheroFisico = File(miCarpeta, "facturas.txt")//BUSCO ARCHIVO
            val fichero = BufferedReader(       //Leer archivo
                InputStreamReader(FileInputStream(ficheroFisico))
            )
            texto = fichero.use(BufferedReader::readText)
        }
        catch (e : Exception) {
            // Nada
        }

        val t=texto.split("\n")
        //t=[["titulo;dia del mes;valor a pagar;cuotas restantes"],["titulo;dia del mes;valor a pagar;cuotas restantes"]]

        //println(t[p].split(","))
        val line= t
        val money= arrayListOf<Factura>()

        for(i in line){
            if(i!=""){


                val t=i.split(";")
                //println(t)   //0=titulo, 1 =DiaDelMes; 2=Valor;3Cuotas Restantes
                //val factura:Factura;
                var c=""
                var k="--------"
                if (t[3]!="-1") {
                    c = t[3]
                }
                if(t[2]!="00"){
                    k=t[2]
                }
                val factura= Factura(t[0],"${t[1]} de cada mes",k,c, R.drawable.egreso)
                money.add(factura)}
        }
        return money
    }

}