open class Reactor<T> {

    private var value: T? = null

    interface Subscription {
        fun cancel()
    }

    open inner class InputCell(private var v: T) {

        private var subs: List<(T) -> Unit> = emptyList()

        var value: T
            get() = v
            set(value) {
                if (value != v) {
                    v = value
                    subs.forEach { it(v) }
                }
            }

        fun addCallback(callback: (T) -> Unit) = let{
            subs = subs + callback
            object : Subscription {
                override fun cancel() {
                    subs = subs - callback
                }
            }
        }

    }

    inner class ComputeCell(vararg val cells: InputCell,
                            val compute: (List<T>) -> T) :
            InputCell(compute(cells.map { it.value })) {

        init { addCallbacks(cells) }

        fun addCallbacks(cells: Array<out InputCell>): Unit =
                cells.forEach {
                    if (it is ComputeCell) addCallbacks(it.cells)
                    else it.addCallback {
                        value = compute(this.cells.map { it.value })
                    }
                }
    }
}
