package fiuba.tdl.kotlin.example.corroutines



import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


fun main() = runBlocking{
    coroutineScope{
        val job = launch{

            println(suspendingFunction())
        }

        print("El resultado es: ")
        job.join()
    }
}

fun suspendingFunction(): String{
    return "funcion suspendida"

}