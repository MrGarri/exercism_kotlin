object Flattener {

    fun flatten(input: List<*>): List<*> = input.flatMap {
        when(it) {
            is Int -> listOf(it)
            is List<*> -> flatten(it)
            else -> emptyList()
        }
    }

}