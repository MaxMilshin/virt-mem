fun optReplacementPosition(arr: MutableList<MutableList<Int>>, memory: IntArray, numOfCycleStep: Int, m : Int, countOfPages: Int) : Int { // возращает позицию, которую нужно заменить
    var replacementPosition = -1 // позиция, которую нужно заменить
    var valueOfReplacementPosition = -1 // следущее обращение к странице на выбранной позиции
    for (pos in 0 until m) {
        val res = searchFirstPositionWhichMoreThanElem(arr[memory[pos]].toIntArray(), numOfCycleStep, countOfPages) // ищем следущее обращение к странице на текущей позиции
        if (res > valueOfReplacementPosition) { // если следущее обращение к странице на текущей позиции позже чем на позиции, которую хотим заменить
            replacementPosition = pos // то обновляем заменямую позицию
            valueOfReplacementPosition = res // и обновляем следущее обращение к заменяемой позиции
        }
    }
    return replacementPosition
}

fun oneExecutionOPT(memory: IntArray, arr: MutableList<MutableList<Int>>, currentPage: Int, numOfCycleStep: Int, m : Int, n : Int, countOfPages: Int) : String { // исполнение OPT для одного запроса
    if (currentPage in memory) // проверка того что текущая страница ещё не содержится в виртуальной памяти
        return message
    var pos = searchFirstPositionWhichMoreThanElem(memory, n - 1, 0) // ищем первую свободный кадр в виртульной памяти
    if (pos >= memory.size) // свободных кадров нет ...
        pos = optReplacementPosition(arr, memory, numOfCycleStep, m, countOfPages)
    memory[pos] = currentPage // в выбранный кадр виртуальной памяти кладём текущую страницу
    return (pos + 1).toString()
}

fun preparation(pages: MutableList<Int>, n : Int) : MutableList<MutableList<Int>> { // фомируем лист arr
    val arr = mutableListOf<MutableList<Int>>()
    for (i in 0 until n)
        arr.add(mutableListOf())
    for (i in 0 until pages.size)
        arr[pages[i]].add(i)
    return arr
}

fun opt(pages: MutableList<Int>, memory: IntArray, m: Int, n : Int) : MutableList<String> {
    val arr = preparation(pages, n) // лист, где для каждой страницы из адрессного пространства хранится лист с моментами времени обращения к ней
    val answer = mutableListOf<String>() // последовательность ответов, возращаемая алгоритмом OPT
    for (i in 0 until pages.size)
        answer.add(oneExecutionOPT(memory, arr, pages[i], i, m, n, pages.size)) // добавляем ответ на текущий запрос
    return answer
}