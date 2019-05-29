package fiuba.tdl.kotlin.example.corroutines

import fiuba.tdl.kotlin.example.measureRunTime

fun String.enMayuscula() : String {
    Thread.sleep(1000)
    return (this.toUpperCase())
}

fun main () {

    measureRunTime {
        val sumaTotal = mutableListOf<String>()
        val listaDeNombres = listOf("Braian", "Vicente", "Hernan")
        for (nombre in listaDeNombres) {
            sumaTotal += nombre.enMayuscula()
        }
        for (value in sumaTotal) {
            println(value)
        }
    }
}