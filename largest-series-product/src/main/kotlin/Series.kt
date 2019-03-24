// Improvements based on https://exercism.io/tracks/kotlin/exercises/largest-series-product/solutions/6334a260c0dc4a7395fd6010730b8b19

class Series(private val serie: String) {
    init {
        require(serie.all(Character::isDigit))
    }

    fun getLargestProduct(length: Int): Int {
        require(serie.length >= length && length >= 0)
        if (serie.isBlank() || length == 0)
            return 1

        return serie.windowed(length)
                .map { it.mulChars() }.max() ?: Int.MIN_VALUE
    }

    private fun String.mulChars() = this.map(Character::getNumericValue).reduce(Int::times)

}