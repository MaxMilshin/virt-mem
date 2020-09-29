import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class LRUKtTest {
    @Test
    fun testWhenAlwaysThereIsEmptyPosition() {
        val memory = IntArray(5) {6}
        val pages = mutableListOf(0, 1, 2, 3, 4)
        val rightAns = mutableListOf("1", "2", "3", "4", "5")
        Assertions.assertEquals(rightAns, lru(pages, memory, 6, 5))
    }
    @Test
    fun testWithoutReplacements() {
        val memory = IntArray(5) {6}
        val pages = mutableListOf(0, 1, 2, 3, 4, 3, 1, 0, 3, 0)
        val rightAns = mutableListOf("1", "2", "3", "4", "5", message, message, message, message, message)
        Assertions.assertEquals(rightAns, lru(pages, memory, 6, 5))
    }
    @Test
    fun testWithTwoReplacements() {
        val memory = IntArray(5) {6}
        val pages = mutableListOf(1, 1, 2, 3, 4, 0, 1, 5, 2)
        val rightAns = mutableListOf("1", message, "2", "3", "4", "5", message, "2", "3")
        Assertions.assertEquals(rightAns, lru(pages, memory, 6, 5))
    }
    @Test
    fun testWithOnlyOneReplacement() {
        val memory = IntArray(5) {6}
        val pages = mutableListOf(0, 1, 2, 0, 4, 3, 5, 0)
        val rightAns = mutableListOf("1", "2", "3", message, "4", "5", "2", message)
        Assertions.assertEquals(rightAns, lru(pages, memory, 6, 5))
    }
    @Test
    fun testWithOnePositionInMemory() {
        val memory = IntArray(1) {6}
        val pages = mutableListOf(0, 1, 0, 2, 2, 3, 0, 1, 1)
        val rightAns = mutableListOf("1", "1", "1", "1", message, "1", "1", "1", message)
        Assertions.assertEquals(rightAns, lru(pages, memory, 6, 1))
    }
}