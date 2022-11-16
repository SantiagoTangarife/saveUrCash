package co.edu.udea.analisis.saveUr.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import co.edu.udea.analisis.saveUr.Fachada
import co.edu.udea.analisis.saveUr.Factura
import co.edu.udea.analisis.saveUr.R
import co.edu.udea.analisis.saveUr.StrategiesGuardar.FacturaSaver
import co.edu.udea.analisis.saveUr.StrategiesGuardar.TransaccionSaver

class FacturaAddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_factura_add)
        //val transaccionS: TransaccionSaver = TransaccionSaver(FacturaSaver())
        val add:Button=findViewById(R.id.addF)
        val fachada = Fachada.getInstancia()

        add.setOnClickListener{
            val titulo:String=findViewById<EditText>(R.id.TituloF).text.toString()
            val dia:String=findViewById<EditText>(R.id.DiaF).text.toString()
            val valor:String=findViewById<EditText>(R.id.ValorF).text.toString()
            val cuotas:String=findViewById<EditText>(R.id.CuotasF).text.toString()
            val factura = Factura(titulo,dia,valor,cuotas,R.drawable.egreso)
            val rutaSD = baseContext.getExternalFilesDir(null)?.absolutePath

            fachada.guardarFactura(factura,rutaSD)
            //transaccionS.guardarFactura(factura,rutaSD)
            val intent: Intent = Intent(this, FacturasMesActivity::class.java)
            startActivity(intent)
        }

    }

    /*fun addFactura(factura: Factura) {//texto= arriendo;25;00;-1
        val outString= factura.toString()

        try {
            val rutaSD = baseContext.getExternalFilesDir(null)?.absolutePath
            val miCarpeta = File(rutaSD, "facturas")
            if (!miCarpeta.exists()) {
                miCarpeta.mkdir()
            }
            val ficheroFisico = File(miCarpeta, "facturas.txt")
            ficheroFisico.appendText("$outString\n")


        }
        catch (e: Exception) {
            Toast.makeText(this,
                "No se ha podido guardar",
                Toast.LENGTH_LONG).show()
        }
    }*/
}