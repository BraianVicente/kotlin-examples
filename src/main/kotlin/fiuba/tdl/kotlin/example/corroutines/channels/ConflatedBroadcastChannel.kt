package fiuba.tdl.kotlin.example.corroutines.channels

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