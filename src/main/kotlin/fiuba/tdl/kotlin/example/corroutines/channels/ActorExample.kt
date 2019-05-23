package fiuba.tdl.kotlin.example.corroutines.channels

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.actor
import kotlin.system.measureTimeMillis

suspend fun CoroutineScope.massiveRun(action: suspend () -> Unit) {
    val n = 100  // number of coroutines to launch
    val k = 100000 // times an action is repeated by each coroutine
    val time = measureTimeMillis {

        val jobs = List(n) {
            coroutineScope {
                launch {
                    // repeat(n) repite n veces el codigo en el bloque
                    repeat(k) { action() }
                }
            }
        }
    jobs.forEach { it.join() }
    }
    println("Completed ${n * k} actions in $time ms")
}

// Tipo de mensaje para counterActor
sealed class CounterMsg
// Mensaje unidireccional para incrementar el  contador
object IncCounter : CounterMsg()
// Request en cual devuelve en CounterMsg()
class GetCounter(val response: CompletableDeferred<Int>) : CounterMsg()



// Creamos una extencion de funcion en cual devuelve un actor que acepta
// mensajs del tipo <CounterMsg>
// Lo que hace es "escuchar" un canal y procesar esos mensajes.
fun CoroutineScope.counterActor() = actor<CounterMsg> {
    // actor state
    var counter = 0
    // Iterar sobre el mensaje recibido.

    for (msg in channel) {
        // unicamente vamos a reaccionar antes estos dos mensajes que se reciban
        when (msg) {
            is IncCounter -> counter++
            // Complete completa el valor de la variable dereferenciada que se envia
            // en el metodo GetCounter.
            is GetCounter -> msg.response.complete(counter)
        }
    }
}

fun main() = runBlocking<Unit> {
    val counter = counterActor() // create the actor
    GlobalScope.massiveRun {
        // Creamos un corredor masivo que envia el mensaje IncCounter a nuestro actor
        counter.send(IncCounter)

    }
    // send a message to get a counter value from an actor
    val response = CompletableDeferred<Int>()
    counter.send(GetCounter(response))
    // Ordenamos que se recupere el valor del derreferenciado objeto.

    println("Counter = ${response.await()}")
    counter.close() // shutdown the actor
}