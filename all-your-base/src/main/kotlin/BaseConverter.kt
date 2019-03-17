class BaseConverter(private val base: Int, digits: IntArray) {

    private var num: Int

    init {
        require(base >= 2) { "Bases must be at least 2." }
        require(digits.isNotEmpty()) { "You must supply at least one digit." }
        require(digits.first() != 0 || digits.size == 1) { "Digits may not contain leading zeros." }
        require(digits.all { it >= 0 }) { "Digits may not be negative." }
        require(digits.all { it < base }) { "All digits must be strictly less than the base." }

        num = digits.fold(0) { acc, digit -> acc * base + digit }

        /* First approach
        num = digits.reversed().foldRightIndexed(0) {
            index, digit, acc -> Math.pow(base.toDouble(), index.toDouble()).roundToInt() * digit + acc
        }
        */
    }

    fun convertToBase(targetBase: Int): IntArray {
        require(targetBase > 1) { "Bases must be at least 2." }
        if (num == 0) return IntArray(1)

        var current = num

        return generateSequence { current % targetBase }.takeWhile {
            current /= targetBase; current > 0 || it > 0
        }.toList().reversed().toIntArray()

    }
}