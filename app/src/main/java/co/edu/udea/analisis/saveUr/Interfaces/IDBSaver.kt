package co.edu.udea.analisis.saveUr.Interfaces

import co.edu.udea.analisis.saveUr.Transaccion

interface IDBSaver {
    fun guardar(transaccion: Transaccion, ruta: String?)
}