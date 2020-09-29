fun lruReplacementPosition(memory: IntArray, lastAppeal: IntArray, m: Int) : Int { // возращает позицию, которую нужно заменить
    var replacementCandidate = 0 // кандидат на замену
    for (pos in 1 until m) {
        if (lastAppeal[memory[pos]] < lastAppeal[memory[replacementCandidate]]) // если к текущей позиции последнее обращение было раньше чем к кандидату на замену
            replacementCandidate = pos // то обновим кандидата на замену
    }
    return replacementCandidate
}

fun oneExecutionLRU(memory: IntArray, lastAppeal: IntArray, currentPage: Int, numOfCycleStep : Int, m: Int, n : Int) : String { // исполнение LRU для одного запроса
    lastAppeal[currentPage] = numOfCycleStep // обновляем последнее обращение к текущей странице
    if (currentPage in memory) // проверка того что текущая страница ещё не лежит в виртуальной памяти
        return message
    var pos = searchFirstPositionWhichMoreThanElem(memory, n - 1, 0) // поиск первого свободного кадра в виртуальной памяти
    if (pos >= memory.size) // свободных кадров нет ...
        pos = lruReplacementPosition(memory, lastAppeal, m) // ищем позицию, которую нужно заменить
    memory[pos] = currentPage // // в выбранный кадр виртуальной памяти кладём текущую страницу
    return (pos + 1).toString()
}

fun lru(pages: MutableList<Int>, memory: IntArray, n: Int, m: Int) : MutableList<String> {
    val lastAppeal = IntArray(n) {-1} // массив, в котором для каждой страницы из адрессного пространства хранится момент времени последнего обращения
    val answer = mutableListOf<String>() // последовательность ответов, возращаемая алгоритмом LRU
    for (i in 0 until pages.size)
        answer.add(oneExecutionLRU(memory, lastAppeal, pages[i], i, m, n)) // добавляем ответ для текущего запроса
    return answer
}