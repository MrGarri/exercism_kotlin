object ETL {

    fun transform(old: Map<Int, List<Char>>): Map<Char, Int> =
            old.flatMap { entry -> entry.value.map {
                it.toLowerCase() to entry.key }
            }.toMap()

}