fun input(pages: MutableList<Int>) : Pair<Int, Int> {
    val n = readLine()!!.toInt()
    val m = readLine()!!.toInt()
    val numOfPages = readLine()!!.toInt()
    for (i in 0 until numOfPages) {
        pages.add(readLine()!!.toInt())
    }
    return Pair(n, m)
}

fun main() {
    var pages = mutableListOf<Int>()
    val res = input(pages)
    val n = res.first
    val m = res.second
    var memory = IntArray(m) {-1}
    println(FIFO(pages, memory))
}