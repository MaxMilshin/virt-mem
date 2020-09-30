const val message = "This page is already in virtual memory"

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
    output(fifo(pages, IntArray(m) {n}, n), lru(pages, IntArray(m) {n}, n, m), opt(pages, IntArray(m) {n}, m, n))
}

