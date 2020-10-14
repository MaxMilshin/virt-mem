import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class PagePlaceInVirtualMemoryTest {
    @Test
    fun simpleTest1() {
        Assertions.assertEquals(0, pagePlaceInVirtualMemory(intArrayOf(1, -1, 2, 4, 3), 1))
    }
    @Test
    fun simpleTest2() {
        Assertions.assertEquals(4, pagePlaceInVirtualMemory(intArrayOf(1, 2, 3, 4, 5), 5))
    }
    @Test
    fun testWhenVirtualMemoryDidNotContainPage() {
        Assertions.assertEquals(-1, pagePlaceInVirtualMemory(intArrayOf(1, 9, 2, 4, 3), 5))
    }
}