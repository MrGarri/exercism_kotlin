import java.lang.StringBuilder

//fun reverse (str: String) = str.reversed()

fun reverse (str: String): String {
    var result = ""

    str.map { result = result.prepend(it) }

    return result
}

fun String.prepend(s: Char): String =
        StringBuilder(this).insert(0, s).toString()
