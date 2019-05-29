fun main(){
    fun datosPersona(): Pair<String,String>{
        return Pair("Braian", "Vicente")
    }

    fun datosDireccion(): Triple<String,Int,String>{
        return Triple("Av. Balbin", 2597, "2 A")
    }
    val persona = datosPersona()

    var (nombre, apellido) = datosPersona()

    println(persona)

    println(nombre)

    println(apellido)

    val (calle,altura,departamento) = datosDireccion()
    println("$nombre $apellido vive en $calle $altura $departamento")
}