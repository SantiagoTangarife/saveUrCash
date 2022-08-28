package co.edu.udea.analisis.saveUr

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_facturas_mes.*
import kotlinx.android.synthetic.main.activity_progreso.*
import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.InputStreamReader
import java.util.ArrayList


class FacturasMesActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_facturas_mes)
        val add:ImageView=findViewById(R.id.add)
        add.setOnClickListener{
            val intent: Intent = Intent(this,FacturaAddActivity::class.java)
            startActivity(intent)
        }


        //val factura=Factura("Arriendo","${25} de cada mes",650F,-1,R.drawable.egreso)
        //val factura2=Factura("Pago","${15} de cada mes", 650F,-1,R.drawable.egreso)

        val listaFacturas= GenerarLista()
        if(listaFacturas.size==0){
            val factura=Factura("----","-- de cada mes","---","-1",R.drawable.egreso)
            listaFacturas.add(factura)
        }
        val adapter=FacturasAdapter(this,listaFacturas)
        listaF.adapter=adapter


    }

    fun CargarF() : List<String> {
        var texto = ""
        try {
            val rutaSD = baseContext.getExternalFilesDir(null)?.absolutePath
            val miCarpeta = File(rutaSD, "facturas")//CREO ARCHIVO Ruta
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
        return t

    }

    fun GenerarLista(): ArrayList<Factura> {
        val line=CargarF()
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
                val factura=Factura(t[0],"${t[1]} de cada mes",k,c,R.drawable.egreso)
                money.add(factura)}
        }
        return money
    }



}