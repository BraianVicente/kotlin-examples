package fiuba.tdl.kotlin.example.corroutines

import fiuba.tdl.kotlin.example.measureRunTimeSuspendable
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch


// suspend fun String.imprimirSaludo(){
fun String.imprimirSaludo(){
    Thread.sleep(1000)
    println("Hola $this")
}


suspend fun main() {

    measureRunTimeSuspendable{
        coroutineScope { //(2)
            val listaDeNombres = listOf("Braian", "Santiago", "Hernan")
            for (nombre in listaDeNombres) {
                launch {
                    nombre.imprimirSaludo()
                }
            }
        }
    }

}
