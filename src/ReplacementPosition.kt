fun getReplacementPosition(algo: ALGO): Int { // возвращает позицию, которую нужно заменить
    var replacementPosition = -1 // позиция, которую нужно заменить
    if (algo.name == "FIFO") {
        replacementPosition = algo.queueOfPages.peek() // берём позицию, которая дольше всего не менялась
        algo.queueOfPages.poll() // удаляем её из начала очереди
    }
    if (algo.name == "LRU") {
        replacementPosition = 0
        for (pos in 0 until algo.memory.memSize) {
            if (algo.lastAppeal[algo.memory.memList[pos]] < algo.lastAppeal[algo.memory.memList[replacementPosition]]) // если к текущей позиции последнее обращение было раньше чем к кандидату на замену
                replacementPosition = pos // то обновим кандидата на замену
        }
    }
    if (algo.name == "OPT") {
        replacementPosition = 0
        var valueOfReplacementPosition = -1 // следущее обращение к странице на позиции, которую нужно заменить
        for (pos in 0 until algo.memory.memSize) {
            if (algo.followingAppeals[algo.memory.memList[pos]].size == 0) // если к странице больше не будет обращений
                return pos // то вернём её
            if (algo.followingAppeals[algo.memory.memList[pos]].first() > valueOfReplacementPosition) { // если следущее обращение к странице на текущей позиции позже чем на позиции, которую хотим заменить
                replacementPosition = pos // то обновляем заменямую позицию
                valueOfReplacementPosition = algo.followingAppeals[algo.memory.memList[pos]].first() // и обновляем следущее обращение к заменяемой позиции
            }
        }
    }
    return replacementPosition
}

