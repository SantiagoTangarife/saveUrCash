package co.edu.udea.analisis.saveUr

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.FOCUSABLES_TOUCH_MODE
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayList

class AhorroProgramadoActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ahorro_programado)


        val buttonSA: Button = findViewById(R.id.AhorroSave)
        var inicio=CargarDb()


        if(inicio== listOf("")){
            inicio= listOf("0","0")
        }


        findViewById<EditText>(R.id.CantidadMonetariaProgramada).hint="$${inicio[0]}"  //dinero
        findViewById<EditText>(R.id.FechasProgramadas).hint="${inicio[1]}"            //cuotas
        buttonSA.setOnClickListener{
            modificarAhorro()
            val intent: Intent = Intent(this,HomeActivity::class.java)
            startActivity(intent)
        }               ////CLICK EN E BOTON GUARDAR
    }


    fun onCheckboxClicked(view: View) {
        val modif=findViewById<CheckBox>(R.id.Edit)     //Habilitar Edicion
        val ahorro=findViewById<EditText>(R.id.CantidadMonetariaProgramada)  //dinero
        val meses=findViewById<EditText>(R.id.FechasProgramadas)            //cuotas
        if(modif.isChecked()){
            ahorro.isFocusableInTouchMode=true
            meses.isFocusableInTouchMode=true
        }
    }

    fun modificarAhorro(){
        //CAPTURO LOS DATOS EDITADOS
        val ahorro=findViewById<EditText>(R.id.CantidadMonetariaProgramada).text.toString().toFloat()  //dinero
        val meses=findViewById<EditText>(R.id.FechasProgramadas).text.toString().toInt()           //cuotas

        //AQUI DEBO CREAR UNA BASE DE DATOS PARA QUE ADQUIERA DICHOS VALORES
        EditarDbA(ahorro,meses)
    }

    fun CargarDb() : List<String> {
        var texto = ""
        try {
            val rutaSD = baseContext.getExternalFilesDir(null)?.absolutePath
            val miCarpeta = File(rutaSD, "ahorro")//CREO ARCHIVO Ruta
            val ficheroFisico = File(miCarpeta, "ahorro.txt")//BUSCO ARCHIVO
            val fichero = BufferedReader(       //Leer archivo
                InputStreamReader(FileInputStream(ficheroFisico))
            )
            texto = fichero.use(BufferedReader::readText)
        }
        catch (e : Exception) {
            // Nada
        }

        val t=texto.split("\n")
        val p=(t.size)-2
        //println(t[p].split(","))
        try {
            return t[p].split(",")
        }
        catch (e: Exception){
            var list= listOf<String>("0","1")
            return list
        }

    }

    fun EditarDbA(ahorro:Float,meses:Int){

        try {
            val rutaSD = baseContext.getExternalFilesDir(null)?.absolutePath
            val miCarpeta = File(rutaSD, "ahorro")
            if (!miCarpeta.exists()) {
                miCarpeta.mkdir()
            }
            val ficheroFisico = File(miCarpeta, "ahorro.txt")

            ficheroFisico.appendText("$ahorro,$meses\n")

                //CADA MES DEBE DISMINUIR EL VALOR DE LA VARIABLE MES EN 1 UNIDAD
        }
        catch (e: Exception) {
            Toast.makeText(this,
                "No se ha podido guardar",
                Toast.LENGTH_LONG).show()
        }

    }


}