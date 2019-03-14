object Isogram {

    fun isIsogram(input: String): Boolean = input.toLowerCase().filter { it.isLetter() }.run { toSet().size == this.length }

}
