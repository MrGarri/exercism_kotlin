object Raindrops {

    fun convert(input: Int): String {
        var result = ""

        if(input % 3 == 0) result = result.plus("Pling")
        if(input % 5 == 0) result = result.plus("Plang")
        if(input % 7 == 0) result = result.plus("Plong")
        if(result.isEmpty()) result = result.plus(input)

        return result
    }

}