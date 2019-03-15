import java.lang.RuntimeException

enum class Classification {
    DEFICIENT, PERFECT, ABUNDANT
}

fun classify(naturalNumber: Int): Classification {
    require(naturalNumber > 0)
    return when {
        naturalNumber.aliquotSum() == naturalNumber -> Classification.PERFECT
        naturalNumber.aliquotSum() < naturalNumber -> Classification.DEFICIENT
        else -> Classification.ABUNDANT
    }
}

private fun Int.aliquotSum() = (1..this/2).filter { this % it == 0 }.sum()
