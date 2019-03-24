class IsbnVerifier {

    fun isValid(isbn: String): Boolean {
        val cleaned = isbn.replace(Regex("[^0-9X]+"), "").reversed()
        if (cleaned.length != 10)
            return false

        return (1..10).map {
            if (cleaned[it - 1] == 'X')
                10
            else
                Character.getNumericValue(cleaned[it - 1]).times(it)
        }.sum().rem(11) == 0
    }

}