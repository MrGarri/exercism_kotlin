class RotationalCipher(private val shift: Int) {

    fun encode(input: String): String {
        val encryption = StringBuilder()

        input.codePoints().forEach { c ->
            when {
                Character.isUpperCase(c) -> encryption.append(((c - 65 + shift) % 26 + 65).toChar())
                Character.isLowerCase(c) -> encryption.append(((c - 97 + shift) % 26 + 97).toChar())
                else -> encryption.append(Character.toChars(c))
            }
        }

        return encryption.toString()
    }
}
