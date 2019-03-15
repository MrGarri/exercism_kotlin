import java.math.BigInteger

object HandshakeCalculator {

    fun calculateHandshake(input: Int): List<Signal> =
            when {
                input >= 16 -> calculateHandshake(input - 16).reversed()
                input >= 8 -> calculateHandshake(input - 8) + listOf(Signal.JUMP)
                input >= 4 -> calculateHandshake(input - 4) + listOf(Signal.CLOSE_YOUR_EYES)
                input >= 2 -> calculateHandshake(input - 2) + listOf(Signal.DOUBLE_BLINK)
                input >= 1 -> calculateHandshake(input - 1) + listOf(Signal.WINK)
                else -> emptyList()
            }

}