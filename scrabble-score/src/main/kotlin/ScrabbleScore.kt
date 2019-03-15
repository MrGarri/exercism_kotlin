object ScrabbleScore {

    fun scoreWord(word: String): Int = word.sumBy { Scores.valueOf(it.toString()
            .toUpperCase()).score }

}