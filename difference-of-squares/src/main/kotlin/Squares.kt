class Squares(private val limit: Int) {

    fun squareOfSum(): Int = (1..limit).sum().square()

    fun sumOfSquares(): Int = (1..limit).sumBy { it.square() }

    fun difference(): Int = squareOfSum() - sumOfSquares()

    private fun Int.square() = this * this

}