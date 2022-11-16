package co.edu.udea.analisis.saveUr.States

import android.animation.ObjectAnimator
import android.widget.ProgressBar
import co.edu.udea.analisis.saveUr.Activity.HomeActivity
import co.edu.udea.analisis.saveUr.Fachada
import co.edu.udea.analisis.saveUr.Interfaces.IEstado
import kotlin.math.abs

abstract class Estado(context: Fachada): IEstado {
    protected open val contexto: Fachada = context

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