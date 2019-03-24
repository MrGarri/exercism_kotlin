class Series(private val serie: String) {
    init {
        require(serie.matches(Regex("[0-9]+")) || serie.isBlank())
    }

    fun getLargestProduct(length: Int): Int {
        require(serie.length >= length && length >= 0)

        return (0..serie.length - length)
                .map {
                    serie.substring(it, it + length).mul()
                }.max() ?: Int.MIN_VALUE
    }


    private fun String.mul() = this.toCharArray().map(Character::getNumericValue).mul()
    private fun List<Int>.mul() = fold(1) { acc, t -> acc.times(t) }

}