const val message = "Please make use of documentation to understand input format"

fun preparation(pages: MutableList<Int>, spaceSize : Int) : MutableList<MutableList<Int>> { // фомируем список списков последующих обращений
    val followingAppeals = mutableListOf<MutableList<Int>>()
    for (i in 0 until spaceSize)
        followingAppeals.add(mutableListOf())
    for (i in 0 until pages.size)
        followingAppeals[pages[i]].add(i)
    return followingAppeals
}

fun countOf2ndAns(arr: MutableList<String>) : Int { // возращает количество ответов второго типа
    var countOfSecondTypeAnswers = 0
    for (elem in arr)
        if (isItCorrectNumber(elem))
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
    val spaceSize: Int // размер адрессного пространства процесса
    val memSize: Int // размер виртуальной памяти
    try {
        val res = if (args[0] == "random") randomInput(args, pages) else input(args[0], pages)
        spaceSize = res.first
        memSize = res.second
    }
    catch (e : Exception){ // ловим исключения
        print("$e\n$message")
        return
    }
    val fifo = ALGO("FIFO", VirtMem(spaceSize, memSize)) // структура для алгоритма FIFO
    val lru = ALGO("LRU", VirtMem(spaceSize, memSize)) // структура для алгоритма LRU
    val opt = ALGO("OPT", VirtMem(spaceSize, memSize)) // структура для алгоритма OPT
    opt.followingAppeals = preparation(pages, spaceSize)
    val fifoAns = mutableListOf<String>() // список ответов на запросы для алгоритма FIFO
    val lruAns = mutableListOf<String>() // список ответов на запросы для алгоритма LRU
    val optAns = mutableListOf<String>() // список ответов на запросы для алгоритма OPT
    for (i in 0 until pages.size) { // обрабатываем каждый запрос каждым из трёх алгоритмов
        fifoAns.add(commonAlgorithm(fifo, pages[i], i))
        lruAns.add(commonAlgorithm(lru, pages[i], i))
        optAns.add(commonAlgorithm(opt, pages[i], i))
    }
    output(fifoAns, lruAns, optAns)
}

