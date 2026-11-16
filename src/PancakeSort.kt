/**
 * Pancake Sort: la única operación permitida es "voltear" los k primeros elementos
 * (como darle la vuelta a una pila de tortitas con una espátula).
 * En cada vuelta: se busca el mayor de la parte no ordenada, se lleva arriba
 * con un volteo y se manda a su posición final con otro volteo.
 * Coste O(n²).
 */
object PancakeSort {

    fun <T : Comparable<T>> ordenar(lista: MutableList<T>): MutableList<T> {
        var tamano = lista.size                // tamaño de la parte aún sin ordenar
        while (tamano > 1) {
            val posMaximo = indiceMaximo(lista, tamano)
            if (posMaximo != tamano - 1) {     // si ya está en su sitio no hacemos nada
                if (posMaximo != 0) voltear(lista, posMaximo) // 1) el mayor pasa a la cima
                voltear(lista, tamano - 1)                    // 2) el mayor baja a su posición final
            }
            tamano--
        }
        return lista
    }

    private fun <T : Comparable<T>> indiceMaximo(lista: List<T>, tamano: Int): Int {
        var maximo = 0
        for (i in 1 until tamano) {
            if (lista[i] > lista[maximo]) maximo = i
        }
        return maximo
    }

    /** Invierte el orden de los elementos de la posición 0 a la k (ambas incluidas). */
    private fun <T> voltear(lista: MutableList<T>, k: Int) {
        var i = 0
        var j = k
        while (i < j) {
            val temp = lista[i]
            lista[i] = lista[j]
            lista[j] = temp
            i++
            j--
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println("===== PANCAKE SORT =====")
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