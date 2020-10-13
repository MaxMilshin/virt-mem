import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class NumeralTest {
    @Test
    fun testFor1() {
        Assertions.assertEquals("1st", numeral(1))
    }
    @Test
    fun testFor2() {
        Assertions.assertEquals("2nd", numeral(2))
    }
    @Test
    fun testFor3() {
        Assertions.assertEquals("3rd", numeral(3))
    }
    @Test
    fun testFor4() {
        Assertions.assertEquals("4th", numeral(4))
    }
    @Test
    fun testFor239() {
        Assertions.assertEquals("239th", numeral(239))
    }
}