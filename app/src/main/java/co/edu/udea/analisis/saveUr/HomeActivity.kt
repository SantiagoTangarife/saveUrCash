package co.edu.udea.analisis.saveUr

import android.animation.ObjectAnimator
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlinx.android.synthetic.main.activity_home.*

import java.io.*
import kotlin.math.abs


//package co.edu.udea.analisis.saveUr.data

class HomeActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val gastado = findViewById<TextView>(R.id.textView4)
        val total = findViewById<TextView>(R.id.textView5)
        val Info:LinearLayout=findViewById(R.id.InfoG)
        val buttonI: Button = findViewById(R.id.Ingresos)
        val buttonE:Button=findViewById(R.id.Egresos)
        val AhorroP:Button=findViewById(R.id.AhorroProg)
        val Factura:Button=findViewById(R.id.Facturas)
        val Prestamos:Button=findViewById(R.id.Prestamos)


        val money=GenerarInfo()
        val registrosInEg=Dinero().RegistroMes(money)
        barra(registrosInEg)
        gastado.text = "$${abs(registrosInEg[1])}"
        total.text = "$${registrosInEg[0]}"

        Info.setOnClickListener{
            InfoG()
        }
        buttonI.setOnClickListener {
        Ingreso()
    }
        buttonE.setOnClickListener {
            Egreso()
        }
        AhorroP.setOnClickListener{
            val intent: Intent = Intent(this,AhorroProgramadoActivity::class.java)
            startActivity(intent)}
        Factura.setOnClickListener{
            val intent: Intent = Intent(this,FacturasMesActivity::class.java)
            startActivity(intent)
        }
        Prestamos.setOnClickListener{
            val intent: Intent = Intent(this,PrestamosActivity::class.java)
            startActivity(intent)
        }



    }

    fun Ingreso() {           //funcion OnClickIngresos
        val intent: Intent = Intent(this,IngresosActivity::class.java)
        startActivity(intent)
    }
    fun InfoG(){
        val intent: Intent = Intent(this,ProgresoActivity::class.java)
        startActivity(intent)
    }
    fun Egreso(){
        val intent: Intent = Intent(this,EgresosActivity::class.java)
        startActivity(intent)
    }


    fun Guardar(texto: String) {//texto= carne;30/07/22;-23000
        try {
            val rutaSD = baseContext.getExternalFilesDir(null)?.absolutePath
            val miCarpeta = File(rutaSD, "datos")
            if (!miCarpeta.exists()) {
                miCarpeta.mkdir()
            }
            val ficheroFisico = File(miCarpeta, "datos.txt")
            ficheroFisico.appendText("$texto\n")


        }
        catch (e: Exception) {
            Toast.makeText(this,
                "No se ha podido guardar",
                Toast.LENGTH_LONG).show()
        }
    }

    fun Cargar() : String {
        var texto = ""
        try {
            val rutaSD = baseContext.getExternalFilesDir(null)?.absolutePath
            val miCarpeta = File(rutaSD, "datos")
            val ficheroFisico = File(miCarpeta, "datos.txt")
            val fichero = BufferedReader(
                InputStreamReader(FileInputStream(ficheroFisico))
            )
            texto = fichero.use(BufferedReader::readText)
        }
        catch (e : Exception) {
            // Nada
        }

        return texto

    }


    fun GenerarInfo(): ArrayList<String> {
         val a=Cargar()
         val money= arrayListOf<String>()
         val line=a.split("\n")
         for(i in line){
             if(i!=""){
                 val t=i.split(";")
                 money.add(t[2])}       //0=titulo, 1 =Fecha; 2=Valor
         }
        return money
     }

    fun barra(InEg: ArrayList<Float>) {
        val cuota=CargarDbAh()

        progressBar2.max= InEg[0].toInt()
        val currentProgress=abs(InEg[1].toInt())+(cuota[0].toFloat()/cuota[1].toInt()).toInt()
        ObjectAnimator.ofInt(progressBar2,"progress",currentProgress).setDuration(1).start()
        val In=InEg[0]
        val Eg=abs(InEg[1])+1+(cuota[0].toFloat()/cuota[1].toInt())

        color(Eg/In)

    }

    fun color(porcen:Float) {

        val tinte:ProgressBar=findViewById(R.id.progressBar2)
        println(porcen)
        if(porcen<0.35){

            tinte.progressDrawable.setColorFilter(Color.GREEN,android.graphics.PorterDuff.Mode.SRC_IN)
        }
        else if(porcen>0.36){

            tinte.progressDrawable.setColorFilter(Color.BLUE,android.graphics.PorterDuff.Mode.SRC_IN)
        }
        else if(porcen>0.55){

            tinte.progressDrawable.setColorFilter(Color.YELLOW,android.graphics.PorterDuff.Mode.SRC_IN)
        }
        else if(porcen>0.80){

            tinte.progressDrawable.setColorFilter(Color.RED,android.graphics.PorterDuff.Mode.SRC_IN)
        }

    }

    fun CargarDbAh() : List<String> {
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
        return t[p].split(",")

    }

}






