package co.edu.udea.analisis.saveUr.States

import android.graphics.Color
import android.widget.ProgressBar
import co.edu.udea.analisis.saveUr.Activity.HomeActivity
import co.edu.udea.analisis.saveUr.Fachada

class Normal(context: Fachada) : Estado(context) {
    override var contexto: Fachada = context

    override fun color(tinte:ProgressBar){
        tinte.progressDrawable.setColorFilter(Color.GREEN,android.graphics.PorterDuff.Mode.SRC_IN)
    }
}