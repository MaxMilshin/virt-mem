fun replacementPosition(memory: IntArray, lastAppeal: IntArray, m: Int) : Int {
    var replacementCandidate = 0
    for (pos in 1 until m) {
        if (lastAppeal[memory[pos]] < lastAppeal[memory[replacementCandidate]])
            replacementCandidate = pos
    }
    return replacementCandidate
}

fun oneExecutionLRU(memory: IntArray, lastAppeal: IntArray, currentPage: Int, numOfCycleStep : Int, m: Int) : String {
    lastAppeal[currentPage] = numOfCycleStep
    if (currentPage in memory)
        return "This page already in virtual memory"
    var pos = searchFirstEmptyPosition(memory)
    if (pos >= memory.size)
        pos = replacementPosition(memory, lastAppeal, m)
    memory[pos] = currentPage
    return pos.toString()
}

fun lru(pages: MutableList<Int>, memory: IntArray, n: Int, m: Int) : MutableList<String> {
    var lastAppeal = IntArray(n) {-1}
    var answer = mutableListOf<String>()
    for (i in 0 until pages.size)
        answer.add(oneExecutionLRU(memory, lastAppeal, pages[i], i, m))
    return answer
}