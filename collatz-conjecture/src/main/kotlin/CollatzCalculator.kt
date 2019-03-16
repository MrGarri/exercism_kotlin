object CollatzCalculator {

    fun computeStepCount(num: Int): Int {
        require(num > 0) {"Only natural numbers are allowed"}
        return generateSequence(num, ::nextStep).takeWhile{it > 1}.count()
    }

    private fun nextStep(curr: Int): Int =
            if (curr % 2 == 0) curr.div(2) else curr.times(3).plus(1)

}