object PrimeFactorCalculator {

    fun primeFactors(n: Int): List<Int> = primeFactors(n.toLong()).map(Long::toInt)

    fun primeFactors(_n: Long): List<Long> {
        var n = _n
        val factors: MutableList<Long> = arrayListOf()

        2L.rangeTo(n / 2 + 1).forEach {
            while (n % it == 0L) {
                if (it.isPrime()) {
                    factors.add(it)
                    n /= it
                }
            }
        }

        return factors
    }

    private fun Long.isPrime(): Boolean =
            1.rangeTo(this)
                    .filter { this.rem(it) == 0L }
                    .count() == 2

}