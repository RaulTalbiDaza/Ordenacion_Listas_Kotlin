# UD01 - Ordenación de listas en Kotlin (PMDM 2026/27)

Implementación y comparación de cinco algoritmos de ordenación **sin usar** `sort()`, `sorted()` ni `sortBy()`.

## Ficheros
| Fichero | Contenido |
|---|---|
| `GenerarDatos.kt` | Genera la lista de 45 vehículos y los 100 números aleatorios únicos (semilla fija, mismos datos para todos) |
| `QuickSort.kt` | QuickSort (partición de Lomuto) |
| `PancakeSort.kt` | Pancake Sort |
| `MergeSort.kt` | MergeSort |
| `HeapSort.kt` | HeapSort |
| `ShellSort.kt` | ShellSort |

## Ejecución
1. Abrir el proyecto en IntelliJ IDEA (Kotlin/JVM) con los `.kt` en `src/main/kotlin`.
2. Ejecutar la función `main` de cada fichero (botón ▶ junto a `main`), o por consola con `kotlinc`:
   ```
   kotlinc GenerarDatos.kt 01_QuickSort.kt -include-runtime -d quick.jar
   java -cp quick.jar QuickSort
   ```
3. Cada programa muestra la lista original, la ordenada, el tiempo en ns/ms y si el resultado es correcto.

## Autor
Raul Talbi Daza
