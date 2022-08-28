package co.edu.udea.analisis.saveUr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import java.io.BufferedReader
import java.io.InputStream
import java.nio.charset.Charset

class MainActivity : AppCompatActivity() {
    private var button: Button?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonII:Button=findViewById(R.id.button)
        buttonII.setOnClickListener{
            onClick()
        }

        val buttonI: Button = findViewById(R.id.google)
        buttonI.setOnClickListener {
            google()
        }

    }

     fun onClick() {
        val cambio: Intent = Intent(this,HomeActivity::class.java)
        startActivity(cambio)

    }
    fun google(){
        val intent: Intent = Intent(this,AhorroProgramadoActivity::class.java)
        startActivity(intent)
    }


}