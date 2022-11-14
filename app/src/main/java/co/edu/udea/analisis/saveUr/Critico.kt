package co.edu.udea.analisis.saveUr

import android.graphics.Color
import android.widget.ProgressBar
import co.edu.udea.analisis.saveUr.Activity.HomeActivity

class Critico(context: HomeActivity) : Estado(context) {
    override var contexto: HomeActivity = context
    override fun color(tinte: ProgressBar){
        tinte.progressDrawable.setColorFilter(Color.RED,android.graphics.PorterDuff.Mode.SRC_IN)
    }
}