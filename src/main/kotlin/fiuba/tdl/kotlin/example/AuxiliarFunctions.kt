package fiuba.tdl.kotlin.example

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlin.system.measureTimeMillis


suspend fun measureRunTimeSuspendable(block: suspend () -> Unit){
    val start = System.nanoTime()
    block()
    val end = System.nanoTime()
    println("${(end-start)/1.0e9} seconds")
}


fun measureRunTime(block: () -> Unit){
    val start = System.nanoTime()
    block()
    val end = System.nanoTime()
    println("${(end-start)/1.0e9} seconds")
}

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
