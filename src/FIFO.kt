import java.util.Queue
import java.util.LinkedList

fun oneExecutionFIFO(queueOfPages: Queue<Int>, memory: IntArray, currentPage: Int, n : Int) : String {
    if (currentPage in memory)
        return "This page already in virtual memory"
    var pos = searchFirstPositionWhichMoreThanElem(memory, n - 1, 0)
    if (pos >= memory.size) {
        pos = queueOfPages.peek()
        queueOfPages.poll()
    }
    queueOfPages.add(pos)
    memory[pos] = currentPage
    return pos.toString()
}

fun fifo(pages: MutableList<Int>, memory: IntArray, n : Int): MutableList<String> {
    var answer = mutableListOf<String>()
    var queueOfPages: Queue<Int> = LinkedList<Int>()
    for (i in 0 until pages.size)
        answer.add(oneExecutionFIFO(queueOfPages, memory, pages[i], n))
    return answer
}