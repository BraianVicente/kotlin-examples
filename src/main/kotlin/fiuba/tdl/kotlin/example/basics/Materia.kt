package fiuba.tdl.kotlin.example.basics

data class Materia (
    val nombre: String,
    val codigo: String,
    var profesorEncargado: String = "Todavia sin asignar",
    val horario: Horario
)

