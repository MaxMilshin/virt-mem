fun optReplacementPosition(arr: MutableList<MutableList<Int>>, numOfCycleStep: Int, m : Int) : Int {
    var replacementPosition = -1
    var valueOfReplacementPosition = -1
    for (pos in 0 until m) {
        val res = searchFirstPositionWhichMoreThanElem(arr[pos].toIntArray(), numOfCycleStep, 1)
        if (res > valueOfReplacementPosition) {
            valueOfReplacementPosition = res
            replacementPosition = pos
        }
    }
    if (replacementPosition == -1)
        return 0
    return replacementPosition
}

fun oneExecutionOPT(memory: IntArray, arr: MutableList<MutableList<Int>>, currentPage: Int, numOfCycleStep: Int, m : Int, n : Int) : String {
    if (currentPage in memory)
        return message
    var pos = searchFirstPositionWhichMoreThanElem(memory, n - 1, 0)
    if (pos >= memory.size)
        pos = optReplacementPosition(arr, numOfCycleStep, m)
    memory[pos] = currentPage
    return pos.toString()
}

fun preparation(pages: MutableList<Int>, n : Int) : MutableList<MutableList<Int>> {
    var arr = mutableListOf<MutableList<Int>>()
    for (i in 0 until n)
        arr.add(mutableListOf<Int>())
    for (i in 0 until pages.size)
        arr[pages[i]].add(i)
    /* for (i in 0 until n)
        println(arr[i]) */
    return arr
}

fun opt(pages: MutableList<Int>, memory: IntArray, m: Int, n : Int) : MutableList<String> {
    var arr = preparation(pages, n)
    var answer = mutableListOf<String>()
    for (i in 0 until pages.size)
        answer.add(oneExecutionOPT(memory, arr, pages[i], i, m, n))
    return answer
}