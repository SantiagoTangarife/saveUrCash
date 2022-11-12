package co.edu.udea.analisis.saveUr

import android.graphics.Color
import android.widget.ProgressBar

class Grave(context: HomeActivity) : Estado(context) {
    override var contexto: HomeActivity = context
    override fun color(tinte: ProgressBar){
        tinte.progressDrawable.setColorFilter(Color.YELLOW,android.graphics.PorterDuff.Mode.SRC_IN)
    }
}