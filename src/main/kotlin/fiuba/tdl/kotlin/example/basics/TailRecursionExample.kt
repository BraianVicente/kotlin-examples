package fiuba.tdl.kotlin.example.basics


fun medirTiempo(block: () -> Unit){
    val start = System.nanoTime()
    block()
    val end = System.nanoTime()
    println("${(end-start)/1.0e9} seconds")
}

fun massiveRun(action: () -> Unit) {
    val n = 100
    val k = 10000
    medirTiempo {
        List(n) {
            repeat(k) { action() }
        }
    }
}

fun tailRecursiveFactorial(n: Long, accum: Long = 1): Long {
    val soFar = n * accum
    return if (n <= 1) {
        soFar
    } else {
        tailRecursiveFactorial(n - 1, soFar)
    }
}

// tailrec le da la señal al compilador de que puede
// intentar reescribir la funcion como un loop si puede.
// Esto es importante pues evita que se genere una excepcion en tiempo
// de ejecution del tipo StackOverflowError
tailrec fun tailRecursiveFactorialOptimized(n: Long, acumulador: Long = 1): Long {
    val valorParcial = n * acumulador
    return if (n <= 1) {
        valorParcial
    } else {
        tailRecursiveFactorialOptimized(n - 1, valorParcial)
    }
}



fun main(){

    medirTiempo {
        tailRecursiveFactorialOptimized(16000)
    }

    medirTiempo {
        tailRecursiveFactorial(16000)
    }
}