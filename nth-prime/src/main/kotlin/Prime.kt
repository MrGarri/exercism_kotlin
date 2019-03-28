import kotlin.coroutines.experimental.buildSequence

object Prime {

    fun nth(num: Int): Int {
        require(num > 0) { "There is no zeroth prime." }
        return generatePrimes().take(num).last()
    }

    private fun generatePrimes() = buildSequence {
        var count = 1
        while (true) {
            if (count.isPrime())
                yield(count)
            count++
        }
    }

    private fun Int.isPrime(): Boolean =
            1.rangeTo(this)
                    .filter { this.rem(it) == 0 }
                    .count() == 2

}