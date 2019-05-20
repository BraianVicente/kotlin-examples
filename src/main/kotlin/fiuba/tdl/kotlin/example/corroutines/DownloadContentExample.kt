package fiuba.tdl.kotlin.example.corroutines

import kotlinx.coroutines.*
import kotlin.Exception


data class Reference(
    val reference: String,
    val location: Any ) {

    suspend fun resolveLocaiton() :Any {
        delay(2000)
        return location
    }

}

fun donwloadContent(location: Any):String {
    when(location){
        is String -> return location
        is DownloadContentExampleException -> throw DownloadContentExampleException("ContenidoInvalido")
        else ->  return "0.0.0.0"
    }
}

fun processContent(ref: Reference, content: String) { println("Longitud de ${ref.reference} es $content")}


suspend fun processReferences( refs: List<Reference>){
//fun processReferences( refs: List<Reference>){

    /* Aqui tenemos el ejemplo de dos tipos de corotinas una en la cual se genera un corte en el hilo de ejecucion y
     * por lo tanto genera un un memory leak.
     * Para resolver esto basta con agregar un coroutineScope, el cual va a asegurar que cada hilo se ejecute por
     * separado y permita que finalice la tarea de manera correcta, evitando de esta manera la perdida de memoria.
     */
    coroutineScope{
        for (ref in refs) {
//            GlobalScope.launch {
            launch {
                val location = ref.resolveLocaiton()
                val content = donwloadContent(location)
                processContent(ref, content)
            }

        }
    }
}

class DownloadContentExampleException(message: String) : Exception(message)


suspend fun main(){
    val referencias =  listOf(
        Reference("master", DownloadContentExampleException("Contenido invalido en master")),
        Reference("localhost","127.0.0.1"),
        Reference("remote","10.1.4.123")
    )

    try {
        processReferences(referencias)
    } catch (e: DownloadContentExampleException){
        println(e.toString())
        println("DownloadContentExampleException")
    } catch  (e: Exception) {
        println(e.toString())
        println("Exception")

    }
}