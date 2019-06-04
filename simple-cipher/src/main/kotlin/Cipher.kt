
import java.util.*

class Cipher() {

    var key: String

    init {
        this.key = generateKey()
    }

    constructor(key: String) : this() {
        require(key.none(Char::isUpperCase) && key.none(Char::isDigit) && !key.isBlank())
        this.key = key
    }

    fun encode(input: String): String {
        val result = StringBuilder()
        for (i in 0 until input.length) {
            val shiftKey = getShiftKey(i)
            result.appendCodePoint((input[i] - 'a' + shiftKey) % 26 + 'a'.toInt())
        }
        return result.toString()
    }

    fun decode(input: String): String {
        val result = StringBuilder()
        for (i in 0 until input.length) {
            val shiftKey = getShiftKey(i)
            val c = input[i].toInt() - shiftKey
            if (c < 'a'.toInt())
                result.appendCodePoint(c + 26)
            else
                result.appendCodePoint(c)
        }
        return result.toString()
    }

    private fun getShiftKey(iteration: Int): Int {
        val c = key[iteration % key.length]
        return c - 'a'
    }

    private fun generateKey(): String {
        return Random().ints(100, 'a'.toInt(), 'z'.toInt() - 1)
                .collect<StringBuilder>(
                        { StringBuilder() },
                        { obj, codePoint -> obj.appendCodePoint(codePoint) },
                        { obj, s -> obj.append(s) }
                ).toString()
    }

}