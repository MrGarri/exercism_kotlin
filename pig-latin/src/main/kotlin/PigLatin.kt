object PigLatin {

    fun translate(input: String): String {
        val split = input.split(" ")

        return split.joinToString(separator = " ") { translateWord(it) }
    }

    private fun translateWord(word: String): String {
        val beginWithVowel = Regex("^([aeiou]|[xy][^aeiou]).*")
        val beginWithQu = Regex("^(qu).*")

        return when {
            beginWithVowel.matches(word) -> word.plus("ay")
            beginWithQu.matches(word) -> translate(word.removeRange(IntRange(0, 1)).plus("qu"))
            else -> {
                val c = word[0]
                translate(word.removeRange(IntRange(0, 0)).plus(c))
            }
        }
    }
}