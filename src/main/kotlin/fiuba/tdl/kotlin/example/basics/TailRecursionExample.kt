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

fun tailRecursiveFactorial(n: Long, acumulador: Long = 1): Long {
    val valorParcial = n * acumulador
    return if (n <= 1) {
        valorParcial
    } else {
        tailRecursiveFactorial(n - 1, valorParcial)
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

    massiveRun{
        tailRecursiveFactorialOptimized(10000)
    }

    massiveRun{
        tailRecursiveFactorial(10000)
    }
}