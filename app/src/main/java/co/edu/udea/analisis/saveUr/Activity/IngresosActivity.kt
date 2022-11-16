package co.edu.udea.analisis.saveUr.Activity

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import co.edu.udea.analisis.saveUr.Fachada
import co.edu.udea.analisis.saveUr.Ingreso
import co.edu.udea.analisis.saveUr.R
import co.edu.udea.analisis.saveUr.StrategiesGuardar.IngresoSaver
import co.edu.udea.analisis.saveUr.StrategiesGuardar.TransaccionSaver
import java.time.LocalDate

class IngresosActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingresos)
        //val transaccionS: TransaccionSaver = TransaccionSaver(IngresoSaver())
        val buttonI: ImageButton = findViewById(R.id.backToHomeI)
        val buttonSave: Button = findViewById(R.id.SaveIngreso)
        val fachada = Fachada.getInstancia()


        buttonI.setOnClickListener {
            backHome()
        }
        buttonSave.setOnClickListener {
            val Titulo = findViewById<TextView>(R.id.IdTituloIngreso)
            val Valor = findViewById<TextView>(R.id.IdValorIngreso)
            val date = LocalDate.now()
            val rutaSD = baseContext.getExternalFilesDir(null)?.absolutePath

            val ingreso = Ingreso(Titulo.text.toString(),Valor.text.toString().toFloat(),R.drawable.ingreso,date.toString())

            //ESCRIBO EL NUEVO DATO EN EL ARCHIVO
            /*try {*/
                fachada.guardarIngreso(ingreso,rutaSD)
             // transaccionS.guardarIngreso(ingreso,rutaSD)
           /* }catch(e: Exception){
                Toast.makeText(this,
                    "No se ha podido guardar",
                    Toast.LENGTH_LONG).show()
            }*/

            backHome()
        }
    }
    fun backHome(){
        val intent: Intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }
    /*fun Guardar(transaccion: Transaccion) {//texto= Pago;30/07/22;23000
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
