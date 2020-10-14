import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class CommonAlgorithmTest {
    private val ans = "This page is already in virtual memory on the "
    @Test
    fun fifoTest1() {
        val algo = ALGO("FIFO", VirtMem(6, 3));
        val pages = listOf(1, 2, 3, 1, 3, 4, 5)
        val rightAns = listOf("1", "2", "3", ans + "1st position", ans + "3rd position", "1", "2")
        for (i in pages.indices) {
            Assertions.assertEquals(rightAns[i], commonAlgorithm(algo, pages[i], i))
        }
    }
    @Test
    fun lruTest1() {
        val algo = ALGO("LRU", VirtMem(6, 3));
        val pages = listOf(1, 2, 3, 1, 3, 4, 5)
        val rightAns = listOf("1", "2", "3", ans + "1st position", ans + "3rd position", "2", "1")
        for (i in pages.indices) {
            Assertions.assertEquals(rightAns[i], commonAlgorithm(algo, pages[i], i))
        }
    }
    @Test
    fun optTest1() {
        val algo = ALGO("OPT", VirtMem(6, 3));
        val pages = mutableListOf(1, 2, 3, 1, 3, 4, 5)
        algo.followingAppeals = preparation(pages, 6)
        val rightAns = listOf("1", "2", "3", ans + "1st position", ans + "3rd position", "1", "1")
        for (i in pages.indices) {
            Assertions.assertEquals(rightAns[i], commonAlgorithm(algo, pages[i], i))
        }
    }
    @Test
    fun fifoTest2() {
        val algo = ALGO("FIFO", VirtMem(5, 3));
        val pages = listOf(2, 1, 4, 3, 3, 4, 1)
        val rightAns = listOf("1", "2", "3", "1", ans + "1st position", ans + "3rd position", ans + "2nd position")
        for (i in pages.indices) {
            Assertions.assertEquals(rightAns[i], commonAlgorithm(algo, pages[i], i))
        }
    }
    @Test
    fun lruTest2() {
        val algo = ALGO("LRU", VirtMem(5, 3));
        val pages = listOf(2, 1, 4, 3, 3, 4, 1)
        val rightAns = listOf("1", "2", "3", "1", ans + "1st position", ans + "3rd position", ans + "2nd position")
        for (i in pages.indices) {
            Assertions.assertEquals(rightAns[i], commonAlgorithm(algo, pages[i], i))
        }
    }
    @Test
    fun optTest2() {
        val algo = ALGO("OPT", VirtMem(5, 3));
        val pages = mutableListOf(2, 1, 4, 3, 3, 4, 1)
        val rightAns = listOf("1", "2", "3", "1", ans + "1st position", ans + "3rd position", ans + "2nd position")
        algo.followingAppeals = preparation(pages, 5)
        for (i in pages.indices) {
            Assertions.assertEquals(rightAns[i], commonAlgorithm(algo, pages[i], i))
        }
    }
    @Test
    fun fifoTest3() {
        val algo = ALGO("FIFO", VirtMem(5, 3));
        val pages = listOf(2, 1, 4, 3, 3, 2, 1)
        val rightAns = listOf("1", "2", "3", "1", ans + "1st position", "2", "3")
        for (i in pages.indices) {
            Assertions.assertEquals(rightAns[i], commonAlgorithm(algo, pages[i], i))
        }
    }
    @Test
    fun lruTest3() {
        val algo = ALGO("LRU", VirtMem(5, 3));
        val pages = listOf(2, 1, 4, 3, 3, 2, 1)
        val rightAns = listOf("1", "2", "3", "1", ans + "1st position", "2", "3")
        for (i in pages.indices) {
            Assertions.assertEquals(rightAns[i], commonAlgorithm(algo, pages[i], i))
        }
    }
    @Test
    fun optTest3() {
        val algo = ALGO("OPT", VirtMem(5, 3));
        val pages = mutableListOf(2, 1, 4, 3, 3, 2, 1)
        val rightAns = listOf("1", "2", "3", "3", ans + "3rd position", ans + "1st position", ans + "2nd position")
        algo.followingAppeals = preparation(pages, 5)
        for (i in pages.indices) {
            Assertions.assertEquals(rightAns[i], commonAlgorithm(algo, pages[i], i))
        }
    }
}