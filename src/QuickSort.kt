/**
 * QuickSort: elige un pivote, coloca a su izquierda los menores o iguales y a su
 * derecha los mayores, y repite recursivamente en cada mitad.
 * Coste medio O(n log n), peor caso O(n²).
 */
object QuickSort {

    fun <T : Comparable<T>> ordenar(lista: MutableList<T>): MutableList<T> {
        quickSort(lista, 0, lista.size - 1)
        return lista
    }

    private fun <T : Comparable<T>> quickSort(lista: MutableList<T>, bajo: Int, alto: Int) {
        if (bajo < alto) {
            val posPivote = particionar(lista, bajo, alto)
            quickSort(lista, bajo, posPivote - 1)
            quickSort(lista, posPivote + 1, alto)
        }
    }

    /** Partición de Lomuto: el pivote es el último elemento. */
    private fun <T : Comparable<T>> particionar(lista: MutableList<T>, bajo: Int, alto: Int): Int {
        val pivote = lista[alto]
        var i = bajo - 1                       // frontera de los elementos <= pivote
        for (j in bajo until alto) {
            if (lista[j] <= pivote) {
                i++
                intercambiar(lista, i, j)
            }
        }
        intercambiar(lista, i + 1, alto)       // el pivote queda en su sitio definitivo
        return i + 1
    }

    private fun <T> intercambiar(lista: MutableList<T>, a: Int, b: Int) {
        val temp = lista[a]
        lista[a] = lista[b]
        lista[b] = temp
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println("===== QUICKSORT =====")
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