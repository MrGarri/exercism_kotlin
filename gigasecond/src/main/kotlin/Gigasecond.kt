import javafx.scene.Parent
import java.time.LocalDate
import java.time.LocalDateTime

data class Gigasecond(val birthDate: LocalDateTime) {

    constructor(date: LocalDate): this(date.atStartOfDay())

    val date: LocalDateTime = birthDate.plusSeconds(Math.pow(10.0, 9.0).toLong())

}