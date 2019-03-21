object BinarySearch {

    fun search(values: List<Int>, key: Int): Int {
        if (values.isEmpty() || values.max()!! < key)
            return -1

        var bottom = 0
        var top = values.size - 1

        while (bottom <= top) {
            val middle = (bottom + top) / 2
            when {
                values[middle] < key -> bottom += 1
                values[middle] > key -> top -= 1
                else -> return middle
            }
        }

        return -1
    }

}