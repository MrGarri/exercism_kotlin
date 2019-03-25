object SumOfMultiples {

    fun sum(set: Set<Int>, num: Int): Int =
            (1 until num).filter { set.areDivisibleBy(it) }.sum()

    private fun Set<Int>.areDivisibleBy(n: Int) =
            this.any { n.rem(it) == 0 }

}