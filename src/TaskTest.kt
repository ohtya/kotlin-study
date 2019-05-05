import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TaskTest {
    @Test
    fun startOk() {
        assertEquals("OK", start())
    }
}