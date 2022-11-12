package co.edu.udea.analisis.saveUr

import android.animation.ObjectAnimator
import android.graphics.Color
import android.widget.ProgressBar
import kotlinx.android.synthetic.main.activity_home.*
import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.InputStreamReader
import kotlin.math.abs

abstract class Estado(context: HomeActivity): IEstado {
    protected open val contexto: HomeActivity = context

    override fun balance(InEg: ArrayList<Float>, progressBar2: ProgressBar, CargarDbAh:List<String>) {
        val cuota=CargarDbAh
        progressBar2.max= InEg[0].toInt()
        val currentProgress= abs(InEg[1].toInt()) +(cuota[0].toFloat()/cuota[1].toInt()).toInt()
        ObjectAnimator.ofInt(progressBar2,"progress",currentProgress).setDuration(1).start()
        val In=InEg[0]
        val Eg= abs(InEg[1]) +1+(cuota[0].toFloat()/cuota[1].toInt())
        //color(Eg/In)
        //color(progressBar2)
        if((Eg/In)<0.35){
            contexto.CambiarEstado(contexto.estadoNormal)     }
        else if((Eg/In)>0.80){
            contexto.CambiarEstado(contexto.estadocritico)     }
        else if((Eg/In)>0.55){
            contexto.CambiarEstado(contexto.estadoGrave)         }
        else if((Eg/In)>0.35){
            contexto.CambiarEstado(contexto.estadoAceptable)   }

    }


   abstract override fun color(ProgressBar2:ProgressBar)



}