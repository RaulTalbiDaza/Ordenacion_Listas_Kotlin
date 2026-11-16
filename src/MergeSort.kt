/**
 * MergeSort: divide la lista por la mitad, ordena cada mitad recursivamente y
 * después MEZCLA las dos mitades ya ordenadas en una lista nueva.
 * Coste O(n log n) siempre, pero necesita memoria extra O(n).
 */
object MergeSort {

    fun <T : Comparable<T>> ordenar(lista: MutableList<T>): MutableList<T> {
        if (lista.size <= 1) return lista      // caso base
        val medio = lista.size / 2
        val izquierda = ordenar(lista.subList(0, medio).toMutableList())
        val derecha = ordenar(lista.subList(medio, lista.size).toMutableList())
        return mezclar(izquierda, derecha)
    }

    private fun <T : Comparable<T>> mezclar(izq: List<T>, der: List<T>): MutableList<T> {
        val resultado = mutableListOf<T>()
        var i = 0
        var j = 0
        while (i < izq.size && j < der.size) {
            if (izq[i] <= der[j]) {
                resultado.add(izq[i]); i++
            } else {
                resultado.add(der[j]); j++
            }
        }
        while (i < izq.size) { resultado.add(izq[i]); i++ }   // restos de la izquierda
        while (j < der.size) { resultado.add(der[j]); j++ }   // restos de la derecha
        return resultado
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println("===== MERGESORT =====")
        probar("Vehículos", GenerarDatos.vehiculos)
        probar("Números", GenerarDatos.numeros)
    }

    /** Trabaja sobre una COPIA para no modificar los datos originales. */
    private fun <T : Comparable<T>> probar(nombre: String, original: List<T>) {
        val copia = original.toMutableList()
        println("\n--- Lista de $nombre: ORIGINAL ---")
        println(original)

        val inicio = System.nanoTime()
        val resultado = ordenar(copia)
        val fin = System.nanoTime()

        println("--- Lista de $nombre: ORDENADA ---")
        println(resultado)
        val ns = fin - inicio
        println("Tiempo: $ns ns (${ns / 1_000_000.0} ms)")
        println("¿Correctamente ordenada? ${GenerarDatos.estaOrdenada(resultado)}")
    }
}