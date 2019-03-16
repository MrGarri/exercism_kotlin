class Matrix(private val matrix: List<List<Int>>) {

    var columns: List<List<Int>> = listOf()
    val saddlePoints: MutableSet<MatrixCoordinate> = hashSetOf()

    init {
        if(matrix.first().isNotEmpty()) {
            columns = getAllColumns()
            calculateSaddlePoints()
        }
    }

    private fun calculateSaddlePoints() =
            matrix.forEachIndexed { i, row ->
                row.forEachIndexed { j, _ ->
                    val min = columns[j].min()
                    if (row.max() == min)
                        saddlePoints.add(MatrixCoordinate(i, j))
                }
            }

    private fun getAllColumns(): List<List<Int>> =
            (0 until matrix.size).map { getSingleColumn(it) }.toList()

    private fun getSingleColumn(index: Int) = matrix.map { it[index] }.toList()

}