/**
 * Algoritmo libre 2: ShellSort.
 * Es una mejora de la ordenación por inserción: compara y desplaza elementos
 * separados por un "salto" que se va reduciendo (n/2, n/4, ... 1), de modo que
 * los elementos se acercan a su posición final mucho antes.
 * Con estos saltos el coste es O(n²) en el peor caso, pero en la práctica es muy rápido.
 */
object ShellSort {

    fun <T : Comparable<T>> ordenar(lista: MutableList<T>): MutableList<T> {
        var salto = lista.size / 2
        while (salto > 0) {
            // Inserción con separación 'salto'
            for (i in salto until lista.size) {
                val actual = lista[i]
                var j = i
                while (j >= salto && lista[j - salto] > actual) {
                    lista[j] = lista[j - salto]   // desplazamos el mayor hacia delante
                    j -= salto
                }
                lista[j] = actual
            }
            salto /= 2
        }
        return lista
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println("===== SHELLSORT =====")
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