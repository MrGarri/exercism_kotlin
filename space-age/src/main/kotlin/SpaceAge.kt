import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.roundToInt
import kotlin.math.roundToLong

class SpaceAge(private val spaceAge: Long) {

    private val _yearInSecondsOnEarth: Double = 31557600.00
    private val _mercuryRelation: Double = 0.2408467
    private val _venusRelation: Double = 0.61519726
    private val _marsRelation: Double = 1.8808158
    private val _jupiterRelation: Double = 11.862615
    private val _saturnRelation: Double = 29.447498
    private val _uranusRelation: Double = 84.016846
    private val _neptuneRelation: Double = 164.79132

    fun onEarth(): Double = spaceAge.div(_yearInSecondsOnEarth).formatTo2Decimals()
    fun onMercury(): Double = onEarth().div(_mercuryRelation).formatTo2Decimals()
    fun onVenus(): Double = onEarth().div(_venusRelation).formatTo2Decimals()
    fun onMars(): Double = onEarth().div(_marsRelation).formatTo2Decimals()
    fun onJupiter(): Double = onEarth().div(_jupiterRelation).formatTo2Decimals()
    fun onSaturn(): Double = onEarth().div(_saturnRelation).formatTo2Decimals()
    fun onUranus(): Double = onEarth().div(_uranusRelation).formatTo2Decimals()
    fun onNeptune(): Double = onEarth().div(_neptuneRelation).formatTo2Decimals()

    private fun Double.formatTo2Decimals() = (this * 100).roundToInt().toDouble() / 100
}