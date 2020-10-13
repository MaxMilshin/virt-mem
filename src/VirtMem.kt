import java.util.*

data class VirtMem(val spaceSize: Int, val memSize: Int) {
    val memList = IntArray(memSize) {-1}
}

data class ALGO(val name: String, val memory: VirtMem) {
    val queueOfPages = LinkedList<Int>()
    val lastAppeal = IntArray(memory.spaceSize) {-1}
    var arr = mutableListOf<MutableList<Int>>()
}
