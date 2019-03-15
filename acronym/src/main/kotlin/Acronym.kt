object Acronym {

    fun generate(input: String): String = input.split(Regex("[^a-zA-Z0-9]+"))
            .map { it.first() }.joinToString("").toUpperCase()

}