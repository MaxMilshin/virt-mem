/* данная функция работает в двух режимах
1) mode = 0:
возращает позицию, на которой лежит первый элемент, больший чем elem
2) mode != 0:
в этом случае mode равен количеству запросов и функция возращает первый элемент, больший чем elem
 */
fun searchFirstPositionWhichMoreThanElem(arr: IntArray, elem: Int, mode: Int) : Int { // функция поиска первого элемента в массиве, который больше чем elem
    var iterator = 0
    while (iterator < arr.size && arr[iterator] <= elem)
        iterator++
    if (mode == 0)
        return iterator
    if (iterator == arr.size)
        return mode
    return arr[iterator]
}
