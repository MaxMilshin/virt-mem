import java.io.File
import kotlin.random.Random
import kotlin.system.exitProcess

fun closeProgram(status: Int) {
    if (status == 0)
        println("Program expected number.\nPlease make use of documentation to understand input format.")
    if (status == 1)
        println("Offered file doesn't exist")
    if (status == 2)
        println("n <= m.\nPlease make use of documentation to understand input format.")
    if (status == 3)
        println("Page number from your request more than n.\nPlease make use of documentation to understand input format.")
    exitProcess(0)
}

fun isItCorrectNumber(s: String) : Boolean {
    return s.matches("\\d+".toRegex())
}

fun input(fileName: String, pages: MutableList<Int>) : Pair<Int, Int> {
    if (!File(fileName).exists())
        closeProgram(1)
    val lines: List<String> = File(fileName).readLines()
    if (!isItCorrectNumber(lines[0]) || !isItCorrectNumber(lines[1]))
        closeProgram(0)
    val n = lines[0].toInt() // размер адрессного пространства
    val m = lines[1].toInt() // количество кадров в виртуальной памяти
    if (n <= m)
        closeProgram(2)
    val sequenceOfPages = lines[2].split(" ").toTypedArray()
    for (elem in sequenceOfPages) {
        if (!isItCorrectNumber(elem))
            closeProgram(0)
        if (elem.toInt() > n)
            closeProgram(3)
        pages.add(elem.toInt() - 1)
    }
    return Pair(n, m)
}

fun randomInput(args: Array<String>, pages: MutableList<Int>) : Pair<Int, Int> { // генерация рандомного списка запросов
    if (!isItCorrectNumber(args[1]) || !isItCorrectNumber(args[2]))
        closeProgram(0)
    val n = args[1].toInt() // размер адрессного пространства
    val m = args[2].toInt() // количество кадров в виртуальной памяти
    if (n <= m)
        closeProgram(2)
    val countOfRequests = args[3].toInt() // количество запросов
    val randomListOfPages = List(countOfRequests) { Random.nextInt(1, n + 1)} // генерация списка запросов
    println("Random sequence of requests:")
    for (elem in randomListOfPages) {
        print("$elem ") // вывод сгенериванного списка
        pages.add(elem - 1)
    }
    println()
    println() // вывод для пустой строки для читабельности выходных данных
    return Pair(n, m)
}