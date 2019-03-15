data class Anagram(val word: String) {

    fun match(listOfWords: List<String>): Set<String> {
        val wordSorted = word.sortToLowercase()

        return listOfWords.filter {
            !it.equals(word, ignoreCase = true) && it.sortToLowercase() == wordSorted
        }.toSet()
    }

    private fun String.sortToLowercase() = toLowerCase().toList().sorted().joinToString(separator = "")

}