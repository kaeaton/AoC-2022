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
			if(winningCombos.containsKey(it)) {
				score += winningCombos[it]!!
			} else {
				val elementPlayed = it.split(" ")[1]
				score += responseValues[elementPlayed]!!
			}
		}
	
        return score
    }

    fun part2(input: List<String>): Int {
		var score = 0

		val actionValues = mapOf("X" to 0,
								 "Y" to 3,
								 "Z" to 6)

		val rockValues = mapOf("X" to "scissors",
							   "Y" to "rock",
							   "Z" to "paper")

		val paperValues = mapOf("X" to "rock",
								"Y" to "paper",
								"Z" to "scissors")

		val scissorValues = mapOf("X" to "paper",
								  "Y" to "scissors",
								  "Z" to "rock")

		val elements = mapOf("A" to rockValues,
							 "B" to paperValues,
							 "C" to scissorValues)

		val elementValues = mapOf("rock" to 1,
								  "paper" to 2,
								  "scissors" to 3)


		input.forEach {
			val round = it.split(" ")

			// Did they play rock paper or scissors?
			val yourResponseLookUpTable = elements[round[0]]!!

			// what were you supposed to play in response?
			val yourResponse = yourResponseLookUpTable[round[1]]

			score += elementValues[yourResponse]!!
			score += actionValues[round[1]]!!
		}
        return score
    }

    val input = readInput("input_2")
    println(part1(input))
    println(part2(input))
}
