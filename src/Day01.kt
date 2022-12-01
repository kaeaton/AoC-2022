fun main() {
    fun part1(input: List<String>): Int {
        var maxCalories = 0
        var currentCalories = 0
        val input = readInput("input_1a")
        input.forEach {
            if(it.isNotEmpty()) {
                currentCalories += it.toInt()
            } else {
                if(currentCalories > maxCalories) {
                    maxCalories = currentCalories
                }
                currentCalories = 0
            }
        }
        return maxCalories
    }

    fun part2(input: List<String>): Int {
        var maxCalories = ArrayList<Int>()
        var currentCalories = 0
        val input = readInput("input_1a")
        input.forEach {
            if(it.isNotEmpty()) {
                currentCalories += it.toInt()
            } else {
                maxCalories.add(currentCalories)
                currentCalories = 0
            }
        }

        maxCalories.sortDescending()

        return maxCalories.slice(0..2).sum()
    }

    val input = readInput("input_1a")
    println(part1(input))
    println(part2(input))
}
