class School {

    private val db: MutableMap<Int, List<String>> = hashMapOf()
    fun db() = db

    fun add(name: String, grade: Int) {
        db[grade] = db.getOrDefault(grade, listOf()).plus(name)
    }

    fun grade(grade: Int) = db.filter { it.key == grade}

    fun sort(): Map<Int, List<String>> = db.toSortedMap(naturalOrder()).mapValues { it.value.sorted() }

}