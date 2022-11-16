package co.edu.udea.analisis.saveUr.StrategiesCarga

import androidx.appcompat.app.AppCompatActivity
import co.edu.udea.analisis.saveUr.Interfaces.IDBLoader
import co.edu.udea.analisis.saveUr.Pago
import co.edu.udea.analisis.saveUr.Transaccion
import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.InputStreamReader
import java.util.ArrayList

class PagosLoader: IDBLoader, AppCompatActivity() {

    override fun cargar(ruta:String?) : List<Pago> {
            var texto = ""
            try {
                val miCarpeta = File(ruta, "deudores")//CREO ARCHIVO Ruta
                val ficheroFisico = File(miCarpeta, "deudores.txt")//BUSCO ARCHIVO
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


            val line=t
            val money= arrayListOf<Pago>()
            var e=" "
            for(i in line){
                if(i!=""){


                    val t=i.split(";")
                    //println(t)   //0=titulo, 1 =cantidad Prestada;

                    val pago= Pago("${t[0]}\n     $${t[1]}", "----", "----", "----")
                    money.add(pago)}
            }
            return money
        }

}