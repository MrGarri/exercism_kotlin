val transcriptions: Map<Char, Char> = HashMap(
        hashMapOf(Pair('G', 'C'), Pair('C', 'G'), Pair('T', 'A'), Pair('A', 'U'))
)

fun transcribeToRna(dna: String): String = dna.map { transcriptions[it] }
        .joinToString(separator = "")
