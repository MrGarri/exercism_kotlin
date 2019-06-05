import kotlin.math.abs

class Clock(private var hour: Int, private var minute: Int) {
    init {
        normalize()
    }

    fun add(minutes: Int) {
        minute += minutes
        normalize()
    }

    fun subtract(minutes: Int) {
        minute -= minutes
        normalize()
    }

    override fun toString() = "%02d:%02d".format(hour, minute)
    override fun equals(other: Any?) =(other as Clock).hour == hour && other.minute == minute

    private fun normalize() {
        if (abs(minute) >= 60) {
            hour += minute / 60
            minute %= 60
        }

        if (minute < 0) {
            hour -= 1
            minute += 60
        }

        if (abs(hour) >= 24) {
            hour %= 24
        }

        if (hour < 0) {
            hour += 24
        }
    }

}