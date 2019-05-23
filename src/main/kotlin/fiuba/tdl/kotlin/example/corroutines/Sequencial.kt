package fiuba.tdl.kotlin.example.corroutines
/*
 * El siguiente ejemplo sirve para mostrar la diferencia entre una
 * corrutina bloqueante y una no bloqueantes.
 *
 */
import kotlinx.coroutines.*



// suspend fun String.imprimirSaludo(){
suspend fun String.imprimirSaludo(){
    delay(1000)
//    Thread.sleep(1000)
    println("Hola $this")
}


private suspend fun medirTiempo(block: suspend () -> Unit){
// private fun medirTiempo(block: () -> Unit){
    val start = System.nanoTime()
    block()
    val end = System.nanoTime()
    println("${(end-start)/1.0e9} seconds")
}

suspend fun main() {
// fun main() {

//    coroutineScope { //(2)
        // de esta manera se hace bloqueante, pero aun asi esta demorando demasiado tiempo.
        // para optimizar esto debemos generar el launch al llamar a la funcion
        // imprimier saludo que es el que toma tiempo
            medirTiempo{
//                  val job = GlobalScope.launch{
                coroutineScope{
                    val listaDeNombres = listOf("Braian", "Santiago", "Hernan")
                    for (nombre in listaDeNombres) {
                        // Las corrutinas son no bloquantes
                        // Es por esa razon que no se llega a imprimir nada
//                        nombre.imprimirSaludo()
                        launch {nombre.imprimirSaludo() }
                    }
                }
//                job.join()
            }
    //  }



    // GlobalScope es un lanzador de una corrutina no bloqueante, lo cual
    // significa que esta no detiene el hilo de ejecucion de nuestro programa
    // y si lo que hace no finaliza antes de la ejecucion del programa, esto
    // no se ve reflejado. Si se quiere modificar esto se tiene que crear
    // un Coroutine


    // Descomentar la siguiente linea para mostrar el hecho de ser algo no bloqueante.
}
