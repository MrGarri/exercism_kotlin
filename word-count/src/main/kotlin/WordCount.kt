object WordCount {

    fun phrase (input: String): Map<String, Int?> {

        val split = input.split(Regex("[, ]+"))

        return split
                .map { it.replace(Regex("[^a-zA-Z0-9']"), "")
                        .toLowerCase()
                        .removeSurrounding("'") }
                .groupingBy { it }
                .eachCount()

    }

}