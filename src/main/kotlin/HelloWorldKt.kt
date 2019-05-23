fun main(){

    fun process(input: Any) {
        when( input ){
            1 -> println("You got one")
            7,8->println("you got seven or eight")
            in 12..19 -> println("Between 12 and 19: $input")
            is String ->println("You got a string that length is ${input.length}")
            else -> println("case process default")
        }
    }



    process(println("HelloWorld"))

    process(15)

}
