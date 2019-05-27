package fiuba.tdl.kotlin.example.corroutines.channels
/* En este ejemplo el canal puede ser consumido unicamente por un
 * consumidor. Cada mensaje que es consumido sale del canal.
 */

import kotlinx.coroutines.ObsoleteCoroutinesApi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

@ObsoleteCoroutinesApi
fun main() = runBlocking {
    val channel = Channel<Int>()
    launch {
        repeat(5) {
            channel.send(it*it)
        }
        channel.close()
    }

    println("begin")
    channel.consumeEach {
        println("Begin Consumer said consumed: $it")

    }

    println("again")
    channel.consumeEach {
        println("Again Consumer said consumed: $it")
    }
}