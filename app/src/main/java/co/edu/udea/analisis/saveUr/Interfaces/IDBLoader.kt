package co.edu.udea.analisis.saveUr.Interfaces

import co.edu.udea.analisis.saveUr.Transaccion


interface IDBLoader {
    fun cargar(ruta: String?):List<Transaccion>
}