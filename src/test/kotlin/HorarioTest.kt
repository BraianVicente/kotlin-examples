//~ package test.kotlin.fiuba.clasekotlin

//~ import main.kotlin.fiuba.clasekotlin.Horario

//~ fun main(){

    //~ val primerTurnoMañan = Horario(8 ,10)
    //~ val segundTurnoMañan = Horario(10,12)
    //~ val tercerTurnoMañan = Horario(12,14)

    //~ val primerTurnoTarde = Horario(13,15)
    //~ val segundTurnoTarde = Horario(15,17)
    //~ val tercerTurnoTarde = Horario(17,19)

    //~ val primerTurnoNoche = Horario(18,20)
    //~ val segundTurnoNoche = Horario(20,22)
    //~ val tercerTurnoNoche = Horario(21,23)


    //~ println("Turno de 08:00 a 10:00 es   compatible con turno de 10:00 a 12:00 : ${ primerTurnoMañan.horariosCompatibles(segundTurnoMañan)}")
    //~ println("Turno de 12:00 a 14:00 es incompatible con turno de 13:00 a 15:00 : ${!tercerTurnoMañan.horariosCompatibles(primerTurnoTarde)}")
    //~ println("Turno de 15:00 a 17:00 es   compatible con turno de 10:00 a 12:00 : ${ segundTurnoTarde.horariosCompatibles(segundTurnoMañan)}")
    //~ println("Turno de 15:00 a 17:00 es   compatible con turno de 13:00 a 15:00 : ${ segundTurnoTarde.horariosCompatibles(primerTurnoTarde)}")
    //~ println("Turno de 18:00 a 20:00 es incompatible con turno de 17:00 a 19:00 : ${!primerTurnoNoche.horariosCompatibles(tercerTurnoTarde)}")
    //~ println("Turno de 20:00 a 22:00 es incompatible con turno de 21:00 a 23:00 : ${!segundTurnoNoche.horariosCompatibles(tercerTurnoNoche)}")
    //~ println("Turno de 21:00 a 23:00 es incompatible con turno de 20:00 a 22:00 : ${!tercerTurnoNoche.horariosCompatibles(segundTurnoNoche)}")
//~}
