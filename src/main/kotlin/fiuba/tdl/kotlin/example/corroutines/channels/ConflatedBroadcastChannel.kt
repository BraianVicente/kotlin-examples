package fiuba.tdl.kotlin.example.corroutines.channels
/*
 * Ejemplo de varios consumidores que consumen de un canal.
 * Aqui consumidores del canal unicamente pueden ver
 * el ultimo mensaje recibido en el canal
 */

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.channels.consumeEach

@ExperimentalCoroutinesApi
@ObsoleteCoroutinesApi
fun main() = runBlocking<Unit> {
    val channel = ConflatedBroadcastChannel<Int>()

    launch {

        channel.consumeEach {
            println("first: $it")
            delay(300)
        }
    }

    launch {
        channel.consumeEach {
            println("second: $it")
            delay(200)
        }
    }

    for (i in 1..10) {
        delay(100)
        channel.send(i)
    }

    launch {
        channel.consumeEach {
            println("-->later: $it")
        }
    }
    delay(1000)
    channel.close()
}