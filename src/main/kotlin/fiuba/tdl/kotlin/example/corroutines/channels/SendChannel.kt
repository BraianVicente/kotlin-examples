package fiuba.tdl.kotlin.example.corroutines.channels

interface SendChannel<in E> {
    public suspend fun send(element: E)
    public fun offer(element: E): Boolean
    public fun close(cause: Throwable? = null): Boolean
}
