class Triangle(a: Double, b: Double, c: Double) {
    init {
        require(a > 0 && b > 0 && c > 0)
        require(a + b >= c && a + c >= b && b + c >= a)
    }

    constructor(a: Int, b: Int, c: Int):
            this(a.toDouble(), b.toDouble(), c.toDouble())

    val isEquilateral = a == b && b == c
    val isIsosceles = a == b || a == c || b == c
    val isScalene = a != b && b != c

}