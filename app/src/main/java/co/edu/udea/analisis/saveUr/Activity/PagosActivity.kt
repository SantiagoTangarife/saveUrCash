package co.edu.udea.analisis.saveUr.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import co.edu.udea.analisis.saveUr.Adapter.PagosAdapter
import co.edu.udea.analisis.saveUr.Pago
import co.edu.udea.analisis.saveUr.R
import kotlinx.android.synthetic.main.activity_pagos.*
import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.InputStreamReader
import java.util.ArrayList

class PagosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagos)
        val back:ImageButton=findViewById(R.id.backP1)
        //val factura=Factura("Arriendo","${25} de cada mes",650F,-1,R.drawable.egreso)
        //val factura2=Factura("Pago","${15} de cada mes", 650F,-1,R.drawable.egreso)
        back.setOnClickListener{
            val intent: Intent = Intent(this, PrestamosActivity::class.java)
            startActivity(intent)
        }
        val listaDeudores= GenerarLista()
        if(listaDeudores.size==0){
            val pago= Pago("----")
            listaDeudores.add(pago)
        }
        val adapter= PagosAdapter(this,listaDeudores)
        listP.adapter=adapter


    }

    fun CargarP() : List<String> {
        var texto = ""
        try {
            val rutaSD = baseContext.getExternalFilesDir(null)?.absolutePath
            val miCarpeta = File(rutaSD, "deudores")//CREO ARCHIVO Ruta
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
        return t

    }

    fun GenerarLista(): ArrayList<Pago> {
        val line=CargarP()
        val money= arrayListOf<Pago>()
        var e=" "
        for(i in line){
            if(i!=""){


                val t=i.split(";")
                //println(t)   //0=titulo, 1 =cantidad Prestada;

                val pago= Pago("${t[0]}\n     $${t[1]}")
                money.add(pago)}
        }
        return money
    }
}