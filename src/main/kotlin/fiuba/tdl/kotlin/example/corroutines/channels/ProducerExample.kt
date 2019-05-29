package fiuba.tdl.kotlin.example.corroutines.channels

import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {

    val multiplesOfThree = produce {
        (1..100).forEach {
            if ((it % 9) == 0)
                send(it)
            //send can only be called inside the ProducerScope
        }

    }

    multiplesOfThree.consumeEach {
        println(it)
    }
}