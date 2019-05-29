package fiuba.tdl.kotlin.example.basics

// Este ejercicio va a incorporar varios conceptos basicos de
// programacion en Kotlin.

fun crearListaDeMaterias(): List<Materia> {
    return listOf(
        Materia(
            "Teoria de Algoritmos",
            "7531",
            "Fernando",
            Horario(18,22)),
        Materia(
            "Algoritmos y Programacion III",
            "7507",
            "Fontela",
            Horario(15,18)),
        Materia(
            "Algoritmos y Programacion II",
            "7541",
            "Wachenchauzer",
            Horario(12,16)),
        Materia(
            "Inteligencia Artificial",
            "7524",
            "Cabrera",Horario(12,14)),
        Materia(
            "Organizacion de Datos",
            "7506",
            "Argelich",
            Horario(18,22))
    )
}

fun Any?.procesarCualquierCosa() {
    when( this ){
        1 -> println("El valor es 1.")
        7,8->println("El valor es 7 u 8")
        in 12..19 -> println("El valor se encuentra entre 12 y 19: $this")
        is String ->println("La longitud de $this es ${this.length} ")
        is Horario -> println ("El horario de clase inicia: ${this.horarioInicio} y termina ${this.horarioFin}")
        is Any? -> {
            this.toString()
            println(this)
        }
        else -> println("Cualquier otra cosa que no entiendo.")
    }
}

fun main() {

    val listaDeMaterias: List<Materia> = crearListaDeMaterias()
    val listaMutable = ArrayList<Horario>()
    listaMutable.add(Horario(10, 12))
    val horarioLaboral = Horario(10,18)
    listaDeMaterias
        .groupBy { a -> a.horario.horariosCompatibles(horarioLaboral) }
        .filter { it.key }
        .flatMap { a -> a.value }
        .forEach {
            it.procesarCualquierCosa()
            it.nombre.procesarCualquierCosa()
            it.codigo.procesarCualquierCosa()
            it.horario.horarioInicio.procesarCualquierCosa()
            it.horario.procesarCualquierCosa()
            it.profesorEncargado.procesarCualquierCosa()
            listaMutable.add(it.horario)
        }


    println("HelloWorld2").procesarCualquierCosa()
    "HelloWorld".procesarCualquierCosa()
    15.procesarCualquierCosa()

    for (unHorario in listaMutable) {
        println(unHorario)
    }


    val horarioInicioMayor: (Horario,Horario) -> (Horario) = { a,b -> if (a.horarioInicio > b.horarioFin)  a else b  }
    listaMutable
        .reduce(horarioInicioMayor)
        .procesarCualquierCosa()

    println("Ahora vamos a procesar un nullo y deberia lanzar una excepcion")
    null.procesarCualquierCosa()

}
