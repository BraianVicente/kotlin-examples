package fiuba.tdl.kotlin.example.basics

import fiuba.tdl.kotlin.example.measureRunTime


fun massiveRun(action: () -> Unit) {
    val n = 100
    val k = 10000
    measureRunTime {
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

    measureRunTime{
        tailRecursiveFactorialOptimized(16000)
    }

    measureRunTime{
        tailRecursiveFactorial(16000)
    }
}