class PhoneNumber(input: String) {

    var number: String? = input.filter(Char::isDigit)

    init {
        when (number!!.length) {
            !in (10..11) -> number = null
            11 -> {
                if (!number!!.startsWith("1"))
                    number = null
                else
                    parseNumber()
            }
            else -> parseNumber()
        }
    }

    private fun parseNumber() {
        if (number!!.length == 11)
            number = number!!.drop(1)

        val areaCode = number!!.slice(IntRange(0, 2))
        val exchangeCode = number!!.slice(IntRange(3, 5))

        if (areaCode[0] !in ('2'..'9') || exchangeCode[0] !in ('2'..'9'))
            number = null
    }

}