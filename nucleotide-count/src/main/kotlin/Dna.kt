class Dna(nucleotides: String) {

    private val _validNucleotides = "ACGT"

    init {
        require(nucleotides.all { it in _validNucleotides })
    }

    val nucleotideCounts: Map<Char, Int> =
            _validNucleotides.map { it to nucleotides.occurrencesOf(it) }.toMap()

    private fun String.occurrencesOf(c: Char) = count { it == c }
}