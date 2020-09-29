fun optReplacementPosition(arr: MutableList<MutableList<Int>>, memory: IntArray, numOfCycleStep: Int, m : Int, countOfPages: Int) : Int {
    var replacementPosition = -1
    var valueOfReplacementPosition = -1
    for (pos in 0 until m) {
        val res = searchFirstPositionWhichMoreThanElem(arr[memory[pos]].toIntArray(), numOfCycleStep, countOfPages)
        if (res > valueOfReplacementPosition) {
            valueOfReplacementPosition = res
            replacementPosition = pos
        }
    }
    return replacementPosition
}

fun oneExecutionOPT(memory: IntArray, arr: MutableList<MutableList<Int>>, currentPage: Int, numOfCycleStep: Int, m : Int, n : Int, countOfPages: Int) : String {
    if (currentPage in memory)
        return message
    var pos = searchFirstPositionWhichMoreThanElem(memory, n - 1, 0)
    if (pos >= memory.size)
        pos = optReplacementPosition(arr, memory, numOfCycleStep, m, countOfPages)
    memory[pos] = currentPage
    return (pos + 1).toString()
}

fun preparation(pages: MutableList<Int>, n : Int) : MutableList<MutableList<Int>> {
    val arr = mutableListOf<MutableList<Int>>()
    for (i in 0 until n)
        arr.add(mutableListOf())
    for (i in 0 until pages.size)
        arr[pages[i]].add(i)
    return arr
}

fun opt(pages: MutableList<Int>, memory: IntArray, m: Int, n : Int) : MutableList<String> {
    val arr = preparation(pages, n)
    val answer = mutableListOf<String>()
    for (i in 0 until pages.size)
        answer.add(oneExecutionOPT(memory, arr, pages[i], i, m, n, pages.size))
    return answer
}