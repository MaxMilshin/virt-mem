import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class SearchFirstEmptyPositionTest {
    @Test
    fun testWhereFirstPositionIsEmpty() {
        Assertions.assertEquals(0, searchFirstEmptyPosition(intArrayOf(-1, 2, 3, -1, 4)))
    }
    @Test
    fun testWhereSecondPositionIsEmpty() {
        Assertions.assertEquals(1, searchFirstEmptyPosition(intArrayOf(0, -1, 3, -1, 4)))
    }
    @Test
    fun testWhereLastPositionIsEmpty() {
        Assertions.assertEquals(3, searchFirstEmptyPosition(intArrayOf(0, 22, 3, -1)))
    }
    @Test
    fun testWithoutEmptyPositions() {
        Assertions.assertEquals(4, searchFirstEmptyPosition(intArrayOf(0, 22, 3, 1)))
    }
}