import java.util.*

object BracketPush {

    fun isValid(input: String): Boolean {
        val stack = Stack<Char>()
        val sanitizedInput = input.filter { it.isBracket() }

        sanitizedInput.forEach {
            if (it.isOpeningBracket()) {
                stack.push(it)
            } else {
                if (stack.isEmpty() || stack.peek().getClosingBracket() != it)
                    return false
                stack.pop()
            }
        }

        return stack.isEmpty()
    }

    private fun Char.getClosingBracket(): Char? =
            when (this) {
                '[' -> ']'
                '{' -> '}'
                '(' -> ')'
                else -> null
            }

    private fun Char.isBracket(): Boolean = this in "()[]{}"
    private fun Char.isOpeningBracket(): Boolean = this in "({["

}