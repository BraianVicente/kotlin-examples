package main.kotlin.fiuba.clasekotlin

data class Horario (
    val horarioInicio: Int,
    val horarioFin: Int
){

    fun horariosCompatibles(horario:Horario): Boolean {
        when (true){
            (this.horarioFin <= horario.horarioInicio) -> return true
            (this.horarioInicio >= horario.horarioFin) -> return true
            (horario.horarioFin <= this.horarioInicio) -> return true
            (horario.horarioInicio >= this.horarioFin) -> return true

            else -> return false
        }

        return false

    }
}