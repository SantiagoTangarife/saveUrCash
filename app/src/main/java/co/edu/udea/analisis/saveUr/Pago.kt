package co.edu.udea.analisis.saveUr

class Pago(val Amigo:String, Titulo: String, Fecha: String, Valor: String) : Transaccion(Titulo, Fecha,
    Valor.toFloat()
) {
}