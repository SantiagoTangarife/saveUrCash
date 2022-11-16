package co.edu.udea.analisis.saveUr

import java.util.*

abstract class Transaccion(protected val Titulo: String, protected val Fecha: String,
                           protected val Valor: Float) {

    override fun toString(): String {
        return "${Titulo};${Fecha};${Valor.toString()}"
    }

}