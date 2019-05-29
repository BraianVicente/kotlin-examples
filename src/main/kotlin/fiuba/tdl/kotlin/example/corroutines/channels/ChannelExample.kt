package fiuba.tdl.kotlin.example.corroutines.channels
/* En este ejemplo el canal puede ser consumido unicamente por un
 * consumidor. Cada mensaje que es consumido sale del canal.
 */

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

suspend fun oneSenderOneConsumer() = runBlocking {

}


suspend fun oneSenderTwoConsumers() = runBlocking<Unit> {
    val channel = ConflatedBroadcastChannel<Int>()


}


fun main() = runBlocking {
    println("Ejemplo con un unico consumidor y productor")
    oneSenderOneConsumer()

    println("Ejemplo con dos consumidores y un productor")
    oneSenderTwoConsumers()

}
