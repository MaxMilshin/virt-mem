import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class HowManySecondTypeAnswersTest {
    @Test
    fun simpleTest1() {
        val arr = mutableListOf("1", "2", "3", message, message, "4")
        Assertions.assertEquals(4, countOf2ndAns(arr))
    }
    @Test
    fun simpleTest2() {
        val arr = mutableListOf("1", message, message, message, "1", message)
        Assertions.assertEquals(2, countOf2ndAns(arr))
    }
}