package co.edu.udea.analisis.saveUr

class Factura(Titulo:String, Fecha:String, Valor:String, val Cuota:String, val Imagen:Int)
    : Transaccion(Titulo, Fecha, Valor.toFloat()){
        override fun toString(): String{
            return "${Titulo};${Fecha};${Valor.toString()};${Cuota}"
        }

        fun getTitle():String{
            return this.Titulo
        }
        fun getDate():String{
            return this.Fecha
        }
        fun getValue():String{
            return this.Valor.toString()
        }
}