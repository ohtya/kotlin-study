package study

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class TaskTest {

    private var task: Task = Task()

    /**
     * Hello, world!
     */
    @Test
    fun startOk() {
        val task = Task()
        assertEquals("OK", task.start())
    }

    /**
     * Java to Kotlin conversion.
     */
    @Test
    fun collection() {
        assertEquals("[1, 2, 3, 42, 555]", task.toJSON(listOf(1, 2, 3, 42, 555)))
    }

    /**
     * Named arguments.
     */
    @Test
    fun testJoinToString() {
        assertEquals(
            "[yes, no, may be]",
            task.joinOptions(listOf("yes", "no", "may be"))
        )
    }

    @Test
    fun testDefaultAndNamedParams() {
        assertEquals(listOf("a42", "b1", "C42", "D2"), task.useFoo())
    }

    /**
     * Lambdas.
     */
    @Test
    fun contains() {
        assertTrue(task.containsEven(listOf(1, 2, 3, 126, 555)))
    }

    @Test
    fun notContains() {
        assertFalse(
            task.containsEven(listOf(43, 33))
        )
    }

    /**
     * Strings.
     */
    private fun testMatch(date: String) = assertTrue(date.matches(task.getPattern().toRegex()))

    private fun testMismatch(date: String) = assertFalse(date.matches(task.getPattern().toRegex()))

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
        assertEquals("[Person(name=Alice, age=29), Person(name=Bob, age=31)]", task.getPeople().toString())
    }

    /**
     * Nullable types.
     */
    private fun testSendMessageToClient(
        client: Task.Client?,
        message: String?,
        expectedEmail: String? = null,
        shouldBeInvoked: Boolean = false
    ) {
        var invoked = false
        val expectedMessage = message
        task.sendMessageToClient(client, message, object : Task.Mailer {
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
            Task.Client(Task.PersonalInfo("bob@gmail.com")),
            "Hi Bob! We have an awesome proposition for you...",
            "bob@gmail.com",
            true
        )
    }

    @Test
    fun noMessage() {
        testSendMessageToClient(Task.Client(Task.PersonalInfo("bob@gmail.com")), null)
    }

    @Test
    fun noEmail() {
        testSendMessageToClient(
            Task.Client(Task.PersonalInfo(null)),
            "Hi Bob! We have an awesome proposition for you..."
        )
    }

    @Test
    fun noPersonalInfo() {
        testSendMessageToClient(Task.Client(null), "Hi Bob! We have an awesome proposition for you...")
    }

    @Test
    fun noClient() {
        testSendMessageToClient(null, "Hi Bob! We have an awesome proposition for you...")
    }

    /**
     * Smart casts.
     */
//    @Test
//    fun testNum() {
//        assertEquals(2, eval(Task.Num(2), "aaa"))
//    }
//
//    @Test
//    fun testSum() {
//        assertEquals(3, eval(Task.Sum(Task.Num(2), Task.Num(1)), "aaa"))
//    }
//
//    @Test
//    fun testRecursion() {
//        assertEquals(6, eval(Task.Sum(Task.Sum(Task.Num(1), Task.Num(2)), Task.Num(3)), "aaa"))
//    }

    /**
     * Extension functions.
     */
//    @Test
//    fun testIntExtension() {
//        assertEquals(Task.RationalNumber(4, 1), 4)
//    }
//
//    @Test
//    fun testPairExtension() {
//        assertEquals(Task.RationalNumber(2, 3), Pair(2, 3))
//    }

    /**
     * Object expressions.
     * SAM conversions.
     * Extension functions on collections.
     */
    @Test
    fun testSort() {
        assertEquals(listOf(5, 2, 1), task.getList())
    }


    /**
     * Comparison.
     */
    @Test
    fun testBefore() {
        val first = Task.MyDate(2014, 5, 10)
        val second = Task.MyDate(2014, 7, 11)
        assertTrue(first < second)
    }

    @Test
    fun testAfter() {
        val first = Task.MyDate(2014, 10, 20)
        val second = Task.MyDate(2014, 7, 11)
        assertTrue(first > second)
    }
}