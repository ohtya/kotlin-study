import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse

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

    @Test
    fun testDefaultAndNamedParams() {
        assertEquals(listOf("a42", "b1", "C42", "D2"), useFoo())
    }

    @Test
    fun notContains() {
        assertFalse(
            containsEven(listOf(43, 33))
        )
    }
}