class DiamondPrinter {

    private fun middlePart(c: Char) = if (c == 'A') c.toString() else c.plus(" ".repeat(2 * (c - 'A') - 1).plus(c))

    fun printToList(c: Char): List<String> {
        val halfUp = ('A'..c).map {
            " ".repeat(c - it).plus(middlePart(it)).plus(" ".repeat(c - it))
        }

        return halfUp.plus(halfUp.reversed().drop(1))
    }

}