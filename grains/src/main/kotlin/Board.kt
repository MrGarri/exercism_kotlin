import java.math.BigInteger

object Board {

    fun getGrainCountForSquare(square: Int): BigInteger {
        require(square in 1..64) { "Only integers between 1 and 64 (inclusive) are allowed" }
        return BigInteger.valueOf(2).pow(square - 1)
    }

    fun getTotalGrainCount(): BigInteger = (1..64).map { getGrainCountForSquare(it) }
            .fold(BigInteger.ZERO, BigInteger::add)

}