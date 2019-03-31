object Atbash {

    private val relations = 'a'.rangeTo('z').zip('z' downTo 'a').toMap()

    fun encode(input: String): String =
            compute(input)
            .chunked(5)
            .joinToString(separator = " ")

    fun decode(input: String): String = compute(input)

    private fun compute(input: String) =
            input.filter(Char::isLetterOrDigit)
                    .toLowerCase()
                    .map { c -> relations.getOrDefault(c, c) }
                    .joinToString(separator = "")
    
}