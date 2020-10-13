const val message = "This page is already in virtual memory"

fun preparation(pages: MutableList<Int>, n : Int) : MutableList<MutableList<Int>> { // фомируем лист arr
    val arr = mutableListOf<MutableList<Int>>()
    for (i in 0 until n)
        arr.add(mutableListOf())
    for (i in 0 until pages.size)
        arr[pages[i]].add(i)
    return arr
}

fun countOf2ndAns(arr: MutableList<String>) : Int { // возращает количество ответов второго типа
    var countOfSecondTypeAnswers = 0
    for (elem in arr)
        if (elem != message)
            countOfSecondTypeAnswers++
    return countOfSecondTypeAnswers
}

fun printlnOfList(arr: MutableList<String>) { // выводит содержимое списка
    for (elem in arr)
        println(elem)
    println()
}

fun output(fifoAns: MutableList<String>, lruAns: MutableList<String>, optAns: MutableList<String>) {
    println("Sequence answers with FIFO algorithm:")
    printlnOfList(fifoAns)
    println("Sequence answers with LRU algorithm:")
    printlnOfList(lruAns)
    println("Sequence answers with OPT algorithm:")
    printlnOfList(optAns)
    val secondTypeAnswers = setOf(Pair(countOf2ndAns(fifoAns), "FIFO"), Pair(countOf2ndAns(lruAns), "LRU"), Pair(countOf2ndAns(optAns), "OPT"))
    for (elem in secondTypeAnswers.sortedBy { elem -> elem.first })
        println("Count of second type answers for ${elem.second} algorithm: ${elem.first}")
}

fun main(args: Array<String>) {
    val pages = mutableListOf<Int>() // последовательность обращений к страницам процесса
    val res = if (args[0] == "random") randomInput(args, pages) else input(args[0], pages)
    val n = res.first // размер адрессного пространства процесса
    val m = res.second // количество кадров в оперативной памяти
    val fifo = ALGO("FIFO", VirtMem(n, m))
    val lru = ALGO("LRU", VirtMem(n, m))
    val opt = ALGO("OPT", VirtMem(n, m))
    opt.arr = preparation(pages, n)
    val fifoAns = mutableListOf<String>()
    val lruAns = mutableListOf<String>()
    val optAns = mutableListOf<String>()
    for (i in 0 until pages.size) {
        fifoAns.add(commonAlgorithm(fifo, pages[i], i))
        lruAns.add(commonAlgorithm(lru, pages[i], i))
        optAns.add(commonAlgorithm(opt, pages[i], i))
    }
    output(fifoAns, lruAns, optAns)
}

