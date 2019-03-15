object Pangram {

    fun isPangram(input: String): Boolean = input.filter { it.isLetter() }
            .toLowerCase().run { toSet().size == 26 }

}