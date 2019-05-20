package fiuba.tdl.kotlin.example.corroutines.channels

interface ReceiveChannel<out E> {
    public suspend fun receive(): E
    public fun poll(): E?
    public fun cancel()
}