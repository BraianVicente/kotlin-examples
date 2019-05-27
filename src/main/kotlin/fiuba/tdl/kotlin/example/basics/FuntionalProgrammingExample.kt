package fiuba.tdl.kotlin.example.basics

fun main() {
    val input = "braian|hernan|vicente"
    val toUpperCase: (String) -> String = { it.toUpperCase() }
    val split: (String) -> List<String> = { it.split("|") }

//    val inputListValue = split(toUpperCase(input))

    val inputListValue = input.let { split }
}