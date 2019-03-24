object Series {

    fun slices(size: Int, str: String): List<List<Int>> =
            str.let { require(size <= str.count() && str.isNotBlank()); it }
                    .windowed(size)
                    .map { it.map(Character::getNumericValue).toList() }

}