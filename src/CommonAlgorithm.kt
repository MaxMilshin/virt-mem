fun searchFirstEmptyPosition(arr: IntArray) : Int {
    var iterator = 0
    while (iterator < arr.size && arr[iterator] != -1)
        iterator++
    return iterator
}

fun pagePlaceInVirtualMemory(memory: IntArray, page: Int) : Int {
    for (pos in memory.indices) {
        if (memory[pos] == page)
            return pos
    }
    return -1
}

fun numeral(num: Int): String { // возращает соответсвующее порядковое числительное
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
        algo.lastAppeal[currentPage] = requestNum
    if (algo.name == "OPT")
        algo.arr[currentPage].removeAt(0)
    var pos = pagePlaceInVirtualMemory(algo.memory.memList, currentPage)
    if (pos != -1)
        return "This page is already in virtual memory on ${numeral(pos + 1)} position"
    pos = searchFirstEmptyPosition(algo.memory.memList)
    if (pos >= algo.memory.memSize) {
        pos = getReplacementPosition(algo)
    }
    if (algo.name == "FIFO")
        algo.queueOfPages.add(pos)
    algo.memory.memList[pos] = currentPage
    return (pos + 1).toString()
}