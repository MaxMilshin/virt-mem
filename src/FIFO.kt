import java.util.Queue
import java.util.LinkedList

fun oneExecutionFIFO(queueOfPages: Queue<Int>, memory: IntArray, currentPage: Int, n : Int) : String { // одноразовый запуск FIFO (для одного запроса)
    if (currentPage in memory) // проверка того что текущая страница ещё не содержится в виртуальной памяти
        return message
    var pos = searchFirstPositionWhichMoreThanElem(memory, n - 1, 0) // поиск первого свободного кадра в виртуальной памяти
    if (pos >= memory.size) { // свободных кадроов нет ...
        pos = queueOfPages.peek() // позиция, которую должна занять наша страница, находится в начале очереди
        queueOfPages.poll() // удаляем первый элемент из очереди
    }
    queueOfPages.add(pos) // добавляем в очередь выбранную позицию
    memory[pos] = currentPage // в выбранный кадр виртуальной памяти кладём текущую страницу
    return (pos + 1).toString()
}

fun fifo(pages: MutableList<Int>, memory: IntArray, n : Int): MutableList<String> {
    val answer = mutableListOf<String>() // последовательность ответов, возращаемая алгоритмом FIFO
    val queueOfPages: Queue<Int> = LinkedList<Int>() // очередь позиций
    for (i in 0 until pages.size)
        answer.add(oneExecutionFIFO(queueOfPages, memory, pages[i], n)) // добавляем ответ для текущего запроса
    return answer
}