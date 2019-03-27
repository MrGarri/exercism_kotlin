enum class Relationship {

    EQUAL, SUBLIST, SUPERLIST, UNEQUAL

}

fun <E> List<E>.relationshipTo(target: List<E>): Relationship =
        when {
            this == target -> Relationship.EQUAL
            this.isEmpty() -> Relationship.SUBLIST
            target.isEmpty() -> Relationship.SUPERLIST
            this.isContainedIn(target) -> Relationship.SUBLIST
            target.isContainedIn(this) -> Relationship.SUPERLIST
            else -> Relationship.UNEQUAL
        }


private fun <T> List<T>.isContainedIn(l: List<T>): Boolean =
        l.windowed(size).any(::equals)



