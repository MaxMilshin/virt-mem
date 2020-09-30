import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class IsItCorrectNumberTest {
    @Test
    fun testWithCorrectNumber1() {
        Assertions.assertEquals(true, isItCorrectNumber("40"))
    }
    @Test
    fun testWithCorrectNumber2() {
        Assertions.assertEquals(true, isItCorrectNumber("0"))
    }
    @Test
    fun testWithCorrectNumber3() {
        Assertions.assertEquals(true, isItCorrectNumber("1091472377802"))
    }
    @Test
    fun testWithIncorrectNumber1() {
        Assertions.assertEquals(false, isItCorrectNumber("001-803"))
    }
    @Test
    fun testWithIncorrectNumber2() {
        Assertions.assertEquals(false, isItCorrectNumber("0.32"))
    }
    @Test
    fun testWithIncorrectNumber3() {
        Assertions.assertEquals(false, isItCorrectNumber("as2awe"))
    }
}