fun searchFirstEmptyPosition(memory: IntArray) : Int {
    var iterator = 0
    while (iterator < memory.size && memory[iterator] != -1)
        iterator++
    return iterator
}