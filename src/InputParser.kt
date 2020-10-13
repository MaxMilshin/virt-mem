import java.io.File
import kotlin.random.Random

fun isItCorrectNumber(s: String) : Boolean {
    return s.matches("\\d+".toRegex())
}

fun input(fileName: String, pages: MutableList<Int>) : Pair<Int, Int> {
    if (!File(fileName).exists())
        throw Exception("File doesn't exist")
    val lines: List<String> = File(fileName).readLines()
    if (lines.size != 2)
        throw Exception("File should contain exactly two lines")
    val firstLine = lines[0].split(" ").toTypedArray()
    if (firstLine.size != 2 || !isItCorrectNumber(firstLine[0]) || !isItCorrectNumber(firstLine[1]))
        throw Exception("1st line should contain exactly two numbers")
    val spaceSize = firstLine[0].toInt() // размер адрессного пространства
    val memSize = firstLine[1].toInt() // количество кадров в виртуальной памяти
    if (spaceSize <= memSize)
        throw Exception("1st line:\nYour space size less equal than your virtual memory size")
    val sequenceOfPages = lines[1].split(" ").toTypedArray()
    for (elem in sequenceOfPages) {
        if (!isItCorrectNumber(elem) || elem.toInt() > spaceSize)
            throw Exception("2nd line should contain only numbers, which less equal than space size")
        pages.add(elem.toInt() - 1)
    }
    return Pair(spaceSize, memSize)
}

fun randomInput(args: Array<String>, pages: MutableList<Int>) : Pair<Int, Int> { // генерация рандомного списка запросов
    if (args.size != 4)
        throw Exception("If you wanna random test, you should give exactly 4 arguments")
    if (!isItCorrectNumber(args[1]) || !isItCorrectNumber(args[2]) || !isItCorrectNumber(args[3]))
        throw Exception("You should give 3 numbers after 'random' word")
    val spaceSize = args[1].toInt() // размер адрессного пространства
    val memSize = args[2].toInt() // количество кадров в виртуальной памяти
    if (spaceSize <= memSize)
        throw Exception("Your space size less equal than your virtual memory size")
    val countOfRequests = args[3].toInt() // количество запросов
    val randomListOfPages = List(countOfRequests) { Random.nextInt(1, spaceSize + 1)} // генерация списка запросов
    println("Random sequence of requests:")
    for (elem in randomListOfPages) {
        print("$elem ") // вывод сгенериванного списка
        pages.add(elem - 1)
    }
    println("\n") // вывод для пустой строки для читабельности выходных данных
    return Pair(spaceSize, memSize)
}