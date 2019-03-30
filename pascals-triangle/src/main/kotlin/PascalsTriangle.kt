object PascalsTriangle {

    fun computeTriangle(rows: Int): List<List<Int>> {
        require(rows >= 0) {"Rows can't be negative!"}
        return generateSequence(listOf(1), ::newRow)
                .take(rows)
                .toList()
    }

    private fun newRow(previousRow: List<Int>) =
            0.rangeTo(previousRow.size).map { calculateSum(it, previousRow) }

    private fun calculateSum(index: Int, previousRow: List<Int>): Int =
            previousRow.getOrElse(index) {0} + previousRow.getOrElse(index - 1) {0}


}