object Bob {

    fun hey(input: String): String {
        val str = input.trim()
        return when {
            str.isEmpty() -> "Fine. Be that way!"
            str.isUppercase() -> return when {
                str.endsWith("?") -> "Calm down, I know what I'm doing!"
                else -> "Whoa, chill out!"
            }
            str.endsWith("?") -> "Sure."
            else -> "Whatever."
        }
    }
    private fun String.isUppercase() =
            this.replace(Regex("[^a-zA-Z]"), "").matches(Regex("^[A-Z]+$"))

}