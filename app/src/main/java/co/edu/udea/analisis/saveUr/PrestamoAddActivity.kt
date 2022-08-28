package co.edu.udea.analisis.saveUr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import java.io.File

class PrestamoAddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prestamo_add)
        val save:Button=findViewById(R.id.savePrestamos)
        val back:ImageButton=findViewById(R.id.backP)
        save.setOnClickListener{
            //guardar contenidos
            Recorrido()
            val intent: Intent = Intent(this,HomeActivity::class.java)
            startActivity(intent)
        }
        back.setOnClickListener{
            val intent: Intent = Intent(this,PrestamosActivity::class.java)
            startActivity(intent)
        }

    }
    fun Recorrido(){
        val us1:EditText=findViewById(R.id.friend1)
        val us2:EditText=findViewById(R.id.friend2)
        val us3:EditText=findViewById(R.id.friend3)
        val us4:EditText=findViewById(R.id.friend4)
        var listaAmigos = listOf<EditText>(us1,us2,us3,us4)
        val pr1:EditText=findViewById(R.id.prestamo1)
        val pr2:EditText=findViewById(R.id.prestamo2)
        val pr3:EditText=findViewById(R.id.prestamo3)
        val pr4:EditText=findViewById(R.id.prestamo4)
        var listaPrestamos= listOf<EditText>(pr1,pr2,pr3,pr4)

        var p=0
        for(i in listaAmigos){

            if(i.text.toString()!=""){

                val texto="${i.text.toString()};${listaPrestamos[p].text.toString()}"

                GuardarP(texto)
            }
            p+=1
        }
    }

    fun GuardarP(texto: String) {//texto= carne;30/07/22;-23000
        try {
            val rutaSD = baseContext.getExternalFilesDir(null)?.absolutePath
            val miCarpeta = File(rutaSD, "deudores")
            if (!miCarpeta.exists()) {
                miCarpeta.mkdir()
            }
            val ficheroFisico = File(miCarpeta, "deudores.txt")
            ficheroFisico.appendText("$texto\n")


        }
        catch (e: Exception) {
            Toast.makeText(this,
                "No se ha podido guardar",
                Toast.LENGTH_LONG).show()
        }
    }

}