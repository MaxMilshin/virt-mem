import java.io.File
import kotlin.random.Random


const val message = "This page is already in virtual memory"

fun how2ndAns(arr: MutableList<String>) : Int { // возращает количество ответов второго типа
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

fun input(fileName: String, pages: MutableList<Int>) : Pair<Int, Int> {
    val lines: List<String> = File(fileName).readLines()
    val n = lines[0].toInt()
    val m = lines[1].toInt()
    val sequenceOfPages = lines[2].split(" ").toTypedArray()
    for (elem in sequenceOfPages)
        pages.add(elem.toInt() - 1)
    return Pair(n, m)
}

fun randomInput(args: Array<String>, pages: MutableList<Int>) : Pair<Int, Int> { // генерация рандомного списка запросов
    val n = args[1].toInt()
    val m = args[2].toInt()
    val countOfRequests = args[3].toInt()
    val randomListOfPages = List(countOfRequests) { Random.nextInt(1, n + 1)}
    println("Random sequence of requests:")
    for (elem in randomListOfPages) {
        print("$elem ")
        pages.add(elem - 1)
    }
    println()
    println()
    return Pair(n, m)
}

fun output(fifoAns: MutableList<String>, lruAns: MutableList<String>, optAns: MutableList<String>) {
    println("Sequence answers with FIFO algorithm:")
    printlnOfList(fifoAns)
    println("Sequence answers with LRU algorithm:")
    printlnOfList(lruAns)
    println("Sequence answers with OPT algorithm:")
    printlnOfList(optAns)
    val secondTypeAnswers = setOf(Pair(how2ndAns(fifoAns), "FIFO"), Pair(how2ndAns(lruAns), "LRU"), Pair(how2ndAns(optAns), "OPT"))
    for (elem in secondTypeAnswers.sortedBy { elem -> elem.first })
        println("Count of second type answers for ${elem.second} algorithm: ${elem.first}")
}

fun main(args: Array<String>) {
    val pages = mutableListOf<Int>() // последовательность обращений к страницам процесса
    val res: Pair<Int, Int>
    if (args[0] == "I_want_random_test")
        res = randomInput(args, pages)
    else
        res = input(args[0], pages)
    val n = res.first // размер адрессного пространства процесса
    val m = res.second // количество кадров в оперативной памяти
    output(fifo(pages, IntArray(m) {n}, n), lru(pages, IntArray(m) {n}, n, m), opt(pages, IntArray(m) {n}, m, n))
}

