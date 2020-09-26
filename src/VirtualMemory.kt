import java.io.File

fun input(fileName: String, pages: MutableList<Int>) : Pair<Int, Int> {
    val lines: List<String> = File(fileName).readLines()
    val n = lines[0].toInt()
    val m = lines[1].toInt()
    var sequenceOfPages = lines[2].split(" ").toTypedArray()
    for (elem in sequenceOfPages)
        pages.add(elem.toInt() - 1)
    return Pair(n, m)
}

fun main(args: Array<String>) {
    var pages = mutableListOf<Int>()
    val res = input(args[0], pages)
    val n = res.first
    val m = res.second
    println(fifo(pages, IntArray(m) {n}, n))
    println(lru(pages, IntArray(m) {n}, n, m))
    println(opt(pages, IntArray(m) {n}, m, n))
}