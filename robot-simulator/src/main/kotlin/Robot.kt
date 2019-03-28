class Robot(var gridPosition: GridPosition, var orientation: Orientation) {
    constructor() : this(GridPosition(0, 0), Orientation.NORTH)

    private fun Orientation.next(): Orientation =
            Orientation.values()[this.ordinal.plus(1).rem(Orientation.values().size)]

    private fun Orientation.previous(): Orientation {
        return if (this.ordinal == 0)
            Orientation.values().last()
        else
            Orientation.values()[this.ordinal - 1]
    }

    fun turnRight() {
        orientation = orientation.next()
    }

    fun turnLeft() {
        orientation = orientation.previous()
    }

    fun advance() {
        gridPosition = when (orientation) {
            Orientation.NORTH -> GridPosition(gridPosition.x, gridPosition.y + 1)
            Orientation.EAST -> GridPosition(gridPosition.x + 1, gridPosition.y)
            Orientation.SOUTH -> GridPosition(gridPosition.x, gridPosition.y - 1)
            Orientation.WEST -> GridPosition(gridPosition.x - 1, gridPosition.y)
        }
    }

    fun simulate(moves: String) {
        moves.forEach {
            when (it) {
                'R' -> turnRight()
                'L' -> turnLeft()
                'A' -> advance()
            }
        }
    }
}