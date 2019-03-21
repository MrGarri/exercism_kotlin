data class Node<T>(val value: T, var previous: Node<T>?, var next: Node<T>?)

class Deque<T> {

    private var first: Node<T>? = null
    private var last: Node<T>? = null

    fun push(value: T) {
        if (isEmpty()) {
            addIfEmpty(value)
        } else {
            val currLast = last
            last = Node(value, currLast, currLast?.next)
            currLast?.next = last
        }
    }

    fun pop(): T? {
        val currLast = last
        last = last?.previous
        return currLast?.value
    }

    fun shift(): T? {
        val currFirst = first
        first = first?.next
        return currFirst?.value
    }

    fun unshift(value: T) {
        if (isEmpty()) {
            addIfEmpty(value)
        } else {
            val currFirst = first
            first = Node(value, currFirst?.previous, currFirst)
            currFirst?.previous = first
        }
    }

    private fun isEmpty() = first == null
    private fun addIfEmpty(value: T) {
        val node = Node(value, null, null)
        first = node
        last = node
    }

}