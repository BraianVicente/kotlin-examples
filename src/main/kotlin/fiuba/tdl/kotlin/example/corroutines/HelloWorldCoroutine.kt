package fiuba.tdl.kotlin.example.corroutines



import kotlinx.coroutines.*


fun main() = runBlocking { //(1)
    //  the GlobalScope is used to spawn a launch coroutine
    val job = GlobalScope.launch { //(2)
        val result = suspendingFunction() //(3)
        print("$result")
    }
    print("The result: ")
    job.join() //(4)
}

// La palabra reservada suspend indica que la funcion es suspendible.

suspend fun suspendingFunction(): String{
    return "suspendingFuction"
}