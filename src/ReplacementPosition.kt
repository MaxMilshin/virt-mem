fun getReplacementPosition(algo: ALGO): Int {
    var replacementPosition = -1
    if (algo.name == "FIFO") {
        replacementPosition = algo.queueOfPages.peek()
        algo.queueOfPages.poll()
    }
    if (algo.name == "LRU") {
        replacementPosition = 0 // кандидат на замену
        for (pos in 0 until algo.memory.memSize) {
            if (algo.lastAppeal[algo.memory.memList[pos]] < algo.lastAppeal[algo.memory.memList[replacementPosition]]) // если к текущей позиции последнее обращение было раньше чем к кандидату на замену
                replacementPosition = pos // то обновим кандидата на замену
        }
    }
    if (algo.name == "OPT") {
        replacementPosition = 0 // позиция, которую нужно заменить
        var valueOfReplacementPosition = -1 // следущее обращение к странице на выбранной позиции
        for (pos in 0 until algo.memory.memSize) {
            if (algo.arr[algo.memory.memList[pos]].size == 0)
                return pos
            if (algo.arr[algo.memory.memList[pos]].first() > valueOfReplacementPosition) { // если следущее обращение к странице на текущей позиции позже чем на позиции, которую хотим заменить
                replacementPosition = pos // то обновляем заменямую позицию
                valueOfReplacementPosition = algo.arr[algo.memory.memList[pos]].first() // и обновляем следущее обращение к заменяемой позиции
            }
        }
    }
    return replacementPosition
}

