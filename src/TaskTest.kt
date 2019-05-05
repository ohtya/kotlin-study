import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TaskTest {
    /**
     * Hello, world!
     */
    @Test
    fun startOk() {
        assertEquals("OK", start())
    }

    /**
     * Java to Kotlin conversion.
     */
    @Test
    fun collection() {
        assertEquals("[1, 2, 3, 42, 555]", toJSON(listOf(1, 2, 3, 42, 555)))
    }

    /**
     * Named arguments.
     */
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

    /**
     * Lambdas.
     */
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

    /**
     * Strings.
     */
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

    /**
     * Data classes.
     */
    @Test
    fun testListOfPeople() {
        assertEquals("[Person(name=Alice, age=29), Person(name=Bob, age=31)]", getPeople().toString())
    }

    /**
     * Nullable types.
     */
    private fun testSendMessageToClient(
        client: Client?,
        message: String?,
        expectedEmail: String? = null,
        shouldBeInvoked: Boolean = false
    ) {
        var invoked = false
        val expectedMessage = message
        sendMessageToClient(client, message, object : Mailer {
            override fun sendMessage(email: String, message: String) {
                invoked = true
                assertEquals(expectedMessage, message)
                assertEquals(expectedEmail, email)
            }
        })
        assertEquals(shouldBeInvoked, invoked)
    }

    @Test
    fun everythingIsOk() {
        testSendMessageToClient(
            Client(PersonalInfo("bob@gmail.com")),
            "Hi Bob! We have an awesome proposition for you...",
            "bob@gmail.com",
            true
        )
    }

    @Test
    fun noMessage() {
        testSendMessageToClient(Client(PersonalInfo("bob@gmail.com")), null)
    }

    @Test
    fun noEmail() {
        testSendMessageToClient(Client(PersonalInfo(null)), "Hi Bob! We have an awesome proposition for you...")
    }

    @Test
    fun noPersonalInfo() {
        testSendMessageToClient(Client(null), "Hi Bob! We have an awesome proposition for you...")
    }

    @Test
    fun noClient() {
        testSendMessageToClient(null, "Hi Bob! We have an awesome proposition for you...")
    }

    /**
     * Smart casts.
     */
    @Test
    fun testNum() {
        assertEquals(2, eval(Num(2)))
    }

    @Test
    fun testSum() {
        assertEquals(3, eval(Sum(Num(2), Num(1))))
    }

    @Test
    fun testRecursion() {
        assertEquals(6, eval(Sum(Sum(Num(1), Num(2)), Num(3))))
    }

    /**
     * Extension functions.
     */
    @Test
    fun testIntExtension() {
        assertEquals(RationalNumber(4, 1), 4.r())
    }

    @Test
    fun testPairExtension() {
        assertEquals(RationalNumber(2, 3), Pair(2, 3).r())
    }

    /**
     * Object expressions.
     * SAM conversions.
     */
    @Test
    fun testSort() {
        assertEquals(listOf(5, 2, 1), getList())
    }
}