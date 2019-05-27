package fiuba.tdl.kotlin.example.basics

fun badRecursiveFactorial(n: Long) : Long {
    return if (n <= 1) {
        n
    } else {
        n * badRecursiveFactorial(n - 1)
    }
}

fun main(){
    medirTiempo {
        badRecursiveFactorial(10000)
    }
}

