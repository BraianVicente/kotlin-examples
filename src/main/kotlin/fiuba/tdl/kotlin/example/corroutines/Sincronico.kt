package fiuba.tdl.kotlin.example.corroutines

/*
 * Ejemplo para comparar un llamado Sincronico y
 * uno asincronico. Mostrando un ejemplo de una
 * funcion que simula ser una operacion externa.
 */
import kotlinx.coroutines.*

// fun String.enMayuscula() : String {
suspend fun String.enMayuscula() : String {

    Thread.sleep(1000)
    return (this.toUpperCase())
}


// fun medirTiempo(block: () -> Unit){
private suspend fun medirTiempo(block: suspend () -> Unit){
    val start = System.nanoTime()
    block()
    val end = System.nanoTime()
    println("${(end-start)/1.0e9} seconds")
}




suspend fun main () {

    coroutineScope{
            launch {
                medirTiempo {

//                    val sumaTotal = mutableListOf<String>()
                    val sumaTotal = mutableListOf<Deferred<String>>()
                    val listaDeNombres = listOf("Braian", "Santiago", "Hernan")
                    for (nombre in listaDeNombres) {
//                        sumaTotal += nombre.enMayuscula()
                        sumaTotal += async{nombre.enMayuscula()}
                    }

                    for (value in sumaTotal) {
                        //println(value)

                        println(value.await())

                    }
                }

        }


    }
}
