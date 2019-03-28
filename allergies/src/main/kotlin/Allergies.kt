class Allergies(private var value: Int) {

    fun isAllergicTo(allergen: Allergen): Boolean = (value and allergen.score) == allergen.score

    fun getList() = Allergen.values().filter { isAllergicTo(it) }

}