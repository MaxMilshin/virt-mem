fun searchFirstPositionWhichMoreThanElem(memory: IntArray, elem: Int, mode: Int) : Int {
    var iterator = 0
    while (iterator < memory.size && memory[iterator] <= elem)
        iterator++
    if (mode == 0)
        return iterator
    if (iterator == memory.size)
        return mode
    return memory[iterator]
}