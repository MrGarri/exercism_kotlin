import java.lang.StringBuilder
import java.util.*

// Solution based on https://exercism.io/tracks/kotlin/exercises/robot-name/solutions/665594b4f0204f7a8e4d244a6be16f86

class Robot {

    var name: String = names.next()

    fun reset() {
        this.name = names.next()
    }

    companion object {
        private val r = Random()
        private val names = generateSequence { getRandomName() }.distinct().iterator()

        private fun getRandomName(): String {
            val sb = StringBuilder()

            // Generate two random letters
            for (i in 0..1)
                sb.append(r.nextInt(26).plus(65).toChar())

            // Generate three random numbers
            for (i in 0..2)
                sb.append(r.nextInt(10))

            return sb.toString()
        }
    }

}