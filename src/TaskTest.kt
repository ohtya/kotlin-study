import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TaskTest {
    @Test
    fun startOk() {
        assertEquals("OK", start())
    }

    @Test
    fun collection() {
        assertEquals("[1, 2, 3, 42, 555]", toJSON(listOf(1, 2, 3, 42, 555)))
    }

    @Test
    fun testJoinToString() {
        assertEquals(
            "[yes, no, may be]",
            joinOptions(listOf("yes", "no", "may be"))
        )
    }
}