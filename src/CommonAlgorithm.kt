fun searchFirstEmptyPosition(memList: IntArray) : Int { // ищет первую свободную позицию в виртуальной памяти
    var iterator = 0
    while (iterator < memList.size && memList[iterator] != -1)
        iterator++
    return iterator
}

fun pagePlaceInVirtualMemory(memory: IntArray, page: Int) : Int { // возвращает позицию страницы в виртуальной памяти
    for (pos in memory.indices) {
        if (memory[pos] == page)
            return pos
    }
    return -1
}

fun numeral(num: Int): String { // возвращает соответсвующее порядковое числительное
    if (num == 1)
        return "1st"
    if (num == 2)
        return "2nd"
    if (num == 3)
        return "3rd"
    return "${num}th"
}

fun commonAlgorithm(algo: ALGO, currentPage: Int, requestNum: Int) : String {
    if (algo.name == "LRU")
        algo.lastAppeal[currentPage] = requestNum // обновление последнего обращения к текущей странице
    if (algo.name == "OPT")
        algo.followingAppeals[currentPage].removeAt(0) // удаление текущей страницы из последующих запросов
    var pos = pagePlaceInVirtualMemory(algo.memory.memList, currentPage) // позиция, на которой лежит текущая страница
    if (pos != -1) // проверка того что текущая страница лежит в витруальной памяти
        return "This page is already in virtual memory on ${numeral(pos + 1)} position"
    pos = searchFirstEmptyPosition(algo.memory.memList) // первая свободная позиция в виртуальной памяти
    if (pos >= algo.memory.memSize) { // свободных позиций нет ...
        pos = getReplacementPosition(algo) // ищем позицию, которую должна занять текущая страница в соответствии с текущим алгоритмом
    }
    if (algo.name == "FIFO")
        algo.queueOfPages.add(pos) // добавляем в очередь выбранную позицию
    algo.memory.memList[pos] = currentPage // обновляем текущее состоянии виртуальной памяти
    return (pos + 1).toString()
}