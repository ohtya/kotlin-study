import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
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

    @Test
    fun testDefaultAndNamedParams() {
        assertEquals(listOf("a42", "b1", "C42", "D2"), useFoo())
    }

    @Test
    fun contains() {
        assertTrue(containsEven(listOf(1, 2, 3, 126, 555)))
    }

    @Test
    fun notContains() {
        assertFalse(
            containsEven(listOf(43, 33))
        )
    }

    private fun testMatch(date: String) = assertTrue(date.matches(getPattern().toRegex()))
    private fun testMismatch(date: String) = assertFalse(date.matches(getPattern().toRegex()))

    @Test
    fun match() {
        testMatch("11 MAR 1952")
    }

    @Test
    fun match1() {
        testMatch("24 AUG 1957")
    }

    @Test
    fun doNotMatch() {
        testMismatch("24 RRR 1957")
    }

    @Test
    fun testListOfPeople() {
        assertEquals("[Person(name=Alice, age=29), Person(name=Bob, age=31)]", getPeople().toString())
    }
}