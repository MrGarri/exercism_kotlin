import java.lang.StringBuilder

object BeerSong {

    private const val zeroBottles = "No more bottles of beer on the wall, no more bottles of beer.\n" +
            "Go to the store and buy some more, 99 bottles of beer on the wall."
    private const val oneBottle = "1 bottle of beer on the wall, 1 bottle of beer.\n" +
            "Take it down and pass it around, no more bottles of beer on the wall."
    private const val twoBottles = "2 bottles of beer on the wall, 2 bottles of beer.\n" +
            "Take one down and pass it around, 1 bottle of beer on the wall."
    private const val nBottles = "%d bottles of beer on the wall, %d bottles of beer.\n" +
            "Take one down and pass it around, %d bottles of beer on the wall."

    fun verses(verse1: Int, verse2: Int): String {
        val sb = StringBuilder()

        (verse1 downTo verse2).map { sb.append(buildVerse(it)).append("\n\n") }

        return sb.removeSuffix("\n").toString()
    }

    private fun buildVerse(n: Int) = when (n) {
        0 -> zeroBottles
        1 -> oneBottle
        2 -> twoBottles
        else -> String.format(nBottles, n, n, n - 1)
    }

}