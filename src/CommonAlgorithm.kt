fun searchFirstEmptyPosition(arr: IntArray) : Int {
    var iterator = 0
    while (iterator < arr.size && arr[iterator] != -1)
        iterator++
    return iterator
}


fun commonAlgorithm(algo: ALGO, currentPage: Int, requestNum: Int) : String {
    if (algo.name == "LRU")
        algo.lastAppeal[currentPage] = requestNum
    if (algo.name == "OPT")
        algo.arr[currentPage].removeAt(0)
    if (currentPage in algo.memory.memList)
        return message
    var pos = searchFirstEmptyPosition(algo.memory.memList)
    if (pos >= algo.memory.memSize) {
        pos = getReplacementPosition(algo)
    }
    if (algo.name == "FIFO")
        algo.queueOfPages.add(pos)
    algo.memory.memList[pos] = currentPage
    return (pos + 1).toString()
}