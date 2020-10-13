import java.util.*

data class VirtMem(val spaceSize: Int, val memSize: Int) {
    val memList = IntArray(memSize) {-1} // массив, отображающий текущее состояние в виртуальной памяти
}

data class ALGO(val name: String, val memory: VirtMem) {
    val queueOfPages = LinkedList<Int>() // очередь страниц в виртуальной памяти для алгоритма FIFO
    val lastAppeal = IntArray(memory.spaceSize) {-1} // массив последних обращений к странице для алгоритма LRU
    var followingAppeals = mutableListOf<MutableList<Int>>() // список списоков последующих обращений для каждой станицы для алгоритма OPT
}
