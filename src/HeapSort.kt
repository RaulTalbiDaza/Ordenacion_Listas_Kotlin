/**
 * Algoritmo libre 1: HeapSort (ordenación por montículo).
 * 1) Convierte la lista en un montículo máximo (el padre siempre es mayor que sus hijos).
 * 2) Intercambia la raíz (el mayor) con el último elemento, reduce el montículo
 *    y "hunde" la nueva raíz para restaurar la propiedad. Se repite hasta acabar.
 * Coste O(n log n) siempre, sin memoria extra.
 */
object HeapSort {

    fun <T : Comparable<T>> ordenar(lista: MutableList<T>): MutableList<T> {
        val n = lista.size
        // Construir el montículo, empezando por el último nodo que tiene hijos
        for (i in n / 2 - 1 downTo 0) {
            hundir(lista, n, i)
        }
        // Extraer el máximo repetidamente
        for (fin in n - 1 downTo 1) {
            intercambiar(lista, 0, fin)
            hundir(lista, fin, 0)
        }
        return lista
    }

    /** Hunde el elemento de la posición 'raiz' hasta que cumpla la propiedad del montículo. */
    private fun <T : Comparable<T>> hundir(lista: MutableList<T>, tamano: Int, raiz: Int) {
        var padre = raiz
        while (true) {
            val hijoIzq = 2 * padre + 1
            val hijoDer = hijoIzq + 1
            var mayor = padre
            if (hijoIzq < tamano && lista[hijoIzq] > lista[mayor]) mayor = hijoIzq
            if (hijoDer < tamano && lista[hijoDer] > lista[mayor]) mayor = hijoDer
            if (mayor == padre) break
            intercambiar(lista, padre, mayor)
            padre = mayor
        }
    }

    private fun <T> intercambiar(lista: MutableList<T>, a: Int, b: Int) {
        val temp = lista[a]
        lista[a] = lista[b]
        lista[b] = temp
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println("===== HEAPSORT =====")
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