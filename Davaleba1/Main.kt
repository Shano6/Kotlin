fun main() {
    println(evenAverage((listOf(11, 6, 25, 8))))
    println(isPalindrome("able was I ere I saw elba"))
}

fun evenAverage(list: List<Int>) =
    list.filterIndexed { index, _ -> index % 2 == 0 }.average().toInt()

fun isPalindrome(string: String): Boolean {
    return string.reversed() == string
}
