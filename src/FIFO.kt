import java.util.Queue
import java.util.LinkedList

fun FIFO(pages: MutableList<Int>, memory: IntArray): MutableList<String> {
    var answer = mutableListOf<String>()
    var queueOfPages: Queue<Int> = LinkedList<Int>()
    for (i in 0 until pages.size) {
        if (pages[i] in memory)
            answer.add("This page already in virtual memory")
        else {
            var pos = searchFirstEmptyPosition(memory)
            if (pos >= memory.size) {
                pos = queueOfPages.peek()
                queueOfPages.poll()
            }
            queueOfPages.add(pos)
            memory[pos] = pages[i]
            answer.add(pos.toString())
        }
    }
    return answer
}