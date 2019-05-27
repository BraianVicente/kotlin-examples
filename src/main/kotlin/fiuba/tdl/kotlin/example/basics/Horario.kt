package fiuba.tdl.kotlin.example.basics


data class Horario (
    val horarioInicio: Int,
    val horarioFin: Int
){

    fun horariosCompatibles(horario:Horario): Boolean {
        when (true){
            (horarioFin <= horario.horarioInicio) -> return true
            (horarioInicio >= horario.horarioFin) -> return true
            (horario.horarioFin <= horarioInicio) -> return true
            (horario.horarioInicio >= horarioFin) -> return true

            else -> return false
        }

        return false

    }


    override fun toString() = "Horario con hora inicio: ${this.horarioInicio}:00 y hora fin: ${this.horarioFin}:00 "
}