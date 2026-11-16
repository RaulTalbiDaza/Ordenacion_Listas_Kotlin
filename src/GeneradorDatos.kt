import kotlin.random.Random

/**
 * Genera las dos listas de datos que usarán TODOS los algoritmos.
 * Se usa una semilla fija para que las listas sean siempre las mismas
 * en cada ejecución y todos los algoritmos trabajen con los mismos datos.
 */
object GenerarDatos {

    private const val SEMILLA = 2026
    private val aleatorio = Random(SEMILLA)

    /** Lista de 45 vehículos distintos, desordenados alfabéticamente. */
    val vehiculos: MutableList<String> = mutableListOf(
        "Toyota Corolla", "Audi A4", "Seat Ibiza", "Ford Focus", "Renault Clio",
        "BMW Serie 3", "Volkswagen Golf", "Peugeot 208", "Citroen C3", "Opel Astra",
        "Fiat 500", "Mazda MX-5", "Honda Civic", "Nissan Qashqai", "Kia Sportage",
        "Hyundai Tucson", "Tesla Model 3", "Volvo XC60", "Skoda Octavia", "Dacia Sandero",
        "Mini Cooper", "Jeep Renegade", "Mercedes Clase A", "Suzuki Swift", "Porsche 911",
        "Ferrari F8", "Lamborghini Huracan", "Alfa Romeo Giulia", "Land Rover Defender", "Mitsubishi Outlander",
        "Subaru Impreza", "Lexus RX", "Jaguar F-Type", "Chevrolet Camaro", "Dodge Charger",
        "Ford Mustang", "Cupra Formentor", "Smart Fortwo", "Yamaha MT-07", "Vespa Primavera",
        "Ducati Monster", "Harley-Davidson Iron 883", "Kawasaki Ninja", "Piaggio Ape", "Iveco Daily"
    ).also { it.shuffle(aleatorio) }

    /** 100 enteros aleatorios entre 1 y 10000, sin repetir y desordenados. */
    val numeros: MutableList<Int> = run {
        val conjunto = LinkedHashSet<Int>()          // un Set evita repetidos
        while (conjunto.size < 100) {
            conjunto.add(aleatorio.nextInt(1, 10001)) // el límite superior es exclusivo
        }
        conjunto.toMutableList()
    }

    /** Comprueba (sin ordenar) que una lista está ordenada de menor a mayor. */
    fun <T : Comparable<T>> estaOrdenada(lista: List<T>): Boolean {
        for (i in 1 until lista.size) {
            if (lista[i - 1] > lista[i]) return false
        }
        return true
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println("Vehículos (${vehiculos.size}):\n$vehiculos")
        println("\nNúmeros (${numeros.size}):\n$numeros")
    }
}