package co.edu.udea.analisis.saveUr.Activity

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.annotation.RequiresApi
import co.edu.udea.analisis.saveUr.Egreso
import co.edu.udea.analisis.saveUr.Fachada
import co.edu.udea.analisis.saveUr.R
import co.edu.udea.analisis.saveUr.StrategiesGuardar.EgresoSaver
import co.edu.udea.analisis.saveUr.StrategiesGuardar.TransaccionSaver
import java.time.LocalDate

class EgresosActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_egresos)
        //val transaccionS: TransaccionSaver = TransaccionSaver(EgresoSaver())
        val buttonE: ImageButton = findViewById(R.id.backToHomeE)
        val buttonSave: Button = findViewById(R.id.SaveEgreso)
        val fachada = Fachada.getInstancia()

        buttonE.setOnClickListener {
            backHome()
        }
        buttonSave.setOnClickListener {
            val Titulo = findViewById<TextView>(R.id.IdTituloEgreso)
            val Valor = findViewById<TextView>(R.id.IdValorEgreso)
            val valor1:Float= Valor.text.toString().toFloat() * -1
            val date = LocalDate.now()
            val rutaSD = baseContext.getExternalFilesDir(null)?.absolutePath

            val egreso = Egreso(Titulo.text.toString(),valor1,R.drawable.egreso,date.toString())
            //ESCRIBO EL NUEVO DATO EN EL ARCHIVO

            fachada.guardarEgreso(egreso, rutaSD)
            //transaccionS.guardarEgreso(egreso, rutaSD)
            backHome()
        }
    }
    fun backHome(){
        val intent: Intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }
    /*fun Guardar(transaccion: Transaccion) {//texto= carne;30/07/22;-23000
        val outString= transaccion.toString()
        try {
            val rutaSD = baseContext.getExternalFilesDir(null)?.absolutePath
            val miCarpeta = File(rutaSD, "datos")
            if (!miCarpeta.exists()) {
                miCarpeta.mkdir()
            }
            val ficheroFisico = File(miCarpeta, "datos.txt")
            ficheroFisico.appendText("$outString\n")


        }
        catch (e: Exception) {
            Toast.makeText(this,
                "No se ha podido guardar",
                Toast.LENGTH_LONG).show()
        }
    }*/
}