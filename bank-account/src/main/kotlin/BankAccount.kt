class BankAccount {

    var balance = 0
        get() {
            check(open)
            return field
        }
        private set

    private var open = true

    fun adjustBalance(quantity: Int) {
        synchronized(this) {
            check(open)
            balance += quantity
        }
    }

    fun close() {
        open = false
    }

}