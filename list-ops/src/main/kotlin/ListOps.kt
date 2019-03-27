object ListOps {

    inline fun <reified T> List<T>.customAppend(l: List<T>) =
            listOf(*this.toTypedArray(), *l.toTypedArray())

    fun <T> List<List<T>>.customConcat(): List<T> {
        val result = arrayListOf<T>()
        for (l in this) {
            for (e in l) result.add(e)
        }
        return result
    }

    fun List<Int>.customFilter(predicate: (Int) -> Boolean): List<Int> {
        val result = arrayListOf<Int>()
        for (e in this) if (predicate(e)) result.add(e)
        return result
    }

    val <T> List<T>.customSize: Int
        get() {
            var count = 0
            for (e in this) count++
            return count
        }

    fun List<Int>.customMap(transform: (Int) -> Int): List<Int> {
        val result = arrayListOf<Int>()
        for (e in this) result.add(transform(e))
        return result
    }

    fun <T, R> List<T>.customFoldLeft (initial: R, operation: (acc: R, T) -> R): R {
        var result = initial
        for (e in this.customReverse()) result = operation(result, e)
        return result
    }

    fun <T, R> List<T>.customFoldRight (initial: R, operation: (acc: R, T) -> R): R {
        var result = initial
        for (e in this) result = operation(result, e)
        return result
    }

    fun <T> List<T>.customReverse(): List<T> {
        val result = arrayListOf<T>()
        for (e in this) result.add(0, e)
        return result
    }
}