import java.lang.StringBuilder

object Luhn {

    fun isValid(input: String): Boolean {
        val sb = StringBuilder(input.replace(" ", ""))
        if (sb.length <= 1 || sb.any { !it.isDigit() })
            return false

        (sb.length - 2 downTo 0 step 2).map {
            sb.replace(it, it+1, sb[it].doubleValue().toString())
        }

        val sum = sb.toString().sum()
        return sum % 10 == 0
    }

    private fun Char.doubleValue(): Char {
        var num = Character.getNumericValue(this)
        num *= 2
        if (num > 9)
            num -= 9

        return (num + '0'.toInt()).toChar()
    }

    private fun String.sum() = this.sumBy { Character.getNumericValue(it) }

}
