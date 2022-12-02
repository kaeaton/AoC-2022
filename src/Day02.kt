fun main() {
    fun part1(input: List<String>): Int {
	
		var score = 0
		
		// val A = "Rock"
		// val B = "Paper"
		// val C = "Scissors"
		
		// Rock = X for 1 point
		// Paper = Y for 2 points
		// Scissors = Z for 3 points
		val responseValues = mapOf("X" to 1, 
								   "Y" to 2, 
								   "Z" to 3)
								   
		val winningCombos = mapOf("A Y" to 8, 
								  "B Z" to 9, 
								  "C X" to 7,
								  "A X" to 4,
								  "B Y" to 5,
								  "C Z" to 6)
		
		input.forEach {
			if(winningCombos.containsKey(it) == true) {
				score += winningCombos[it]
			} else {
				val elementPlayed = it.split(" ")[1]
				score += responseValues[elementPlayed]
			}
		}
	
        return score
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 1)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
