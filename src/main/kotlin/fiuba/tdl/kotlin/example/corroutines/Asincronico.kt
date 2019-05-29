package fiuba.tdl.kotlin.example.corroutines

/*
 * Ejemplo para comparar un llamado Sincronico y
 * uno asincronico. Mostrando un ejemplo de una
 * funcion que simula ser una operacion externa.
 */
import fiuba.tdl.kotlin.example.measureRunTimeSuspendable
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch


suspend fun main () {

    coroutineScope{
        launch {
            measureRunTimeSuspendable {
                val sumaTotal = mutableListOf<Deferred<String>>()
                val listaDeNombres = listOf("Braian", "Vicente", "Hernan")
                for (nombre in listaDeNombres) {
                    sumaTotal += async{nombre.enMayuscula()}
                }
                for (value in sumaTotal) {
                    println(value.await())
                }
            }
        }
    }
}
