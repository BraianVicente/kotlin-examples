fun main(){
    fun decirHola(talVez : String?, jamasNulo : Int) {
        // uso del operador Elvis
        // El operador elvis sirve para crear la asignacion segura de datos
        // En caos de que talVez sea nulo va a asignar el valor "extraño"
        val nombre : String = talVez ?: "extraño"
        println("Hola, $nombre")
    }

    decirHola(null,123) // > Hola, extraño


    decirHola("braian",123) // > Hola, braian.

}

