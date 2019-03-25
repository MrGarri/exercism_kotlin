object Sieve {

//    fun primesUpTo(limit: Int): List<Int> {
//        val candidates =
//                (2..limit).zip(Array(limit - 1) { false }).toMutableList()
//
//        for (i in 0..limit-2) {
//            if (!candidates[i].second) {
//                for (j in i+candidates[i].first..limit-2 step candidates[i].first)
//                    candidates[j] = Pair(candidates[j].first, true)
//            }
//        }
//
//        return candidates.filter { !it.second }.map { it.first }.toList()
//    }

    fun primesUpTo(limit: Int): List<Int> = (2..limit).filter { it.isPrime() }

    private fun Int.isPrime(): Boolean =
            1.rangeTo(this)
                    .filter { this.rem(it) == 0 }
                    .count() == 2

}