import kotlin.math.abs

fun main() {
    fun getSortedLists(input: List<String>): Pair<List<Int>, List<Int>> {
        val lefts = mutableListOf<Int>()
        val rights = mutableListOf<Int>()
        val delimiter = "   "
        input.forEach {
            val numbers = it.split(delimiter)
            lefts.add(numbers[0].toInt())
            rights.add(numbers[1].toInt())
        }
        return Pair(lefts.sorted(), rights.sorted())
    }

    fun part1(input: List<String>): Int {
        val (lefts, rights) = getSortedLists(input)
        return lefts.zip(rights).sumOf { (left, right) -> abs(left - right) }
    }

    fun part2(input: List<String>): Int {
        val (lefts, rights) = getSortedLists(input)
        return lefts
            .map { left ->
                Pair(
                    left,
                    rights.count { right -> left == right }
                )
            }
            .sumOf {
                (left, right) -> right * left
            }
    }


    // Test if implementation meets criteria from the description, like:
    check(part1(listOf("3   4", "4   3", "2   5", "1   3", "3   9", "3   3")) == 11)

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 11)
    check(part2(testInput) == 31)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
