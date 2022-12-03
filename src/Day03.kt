fun main() {

	// setup itemValues map
	val itemValues = LinkedHashMap<String,Int>()
	var alph = 'a'
	var i = 1
	while(alph <= 'z') {
		itemValues[alph.toString()] = i
		alph++
		i++
	}
	alph = 'A'
	while(alph <= 'Z') {
		itemValues[alph.toString()] = i
		alph++
		i++
	}

    fun part1(input: List<String>): Int {
		var score = 0

		// processing input
		input.forEach {

			// break down inventory
			val partA = it.slice(0..((it.length / 2) - 1))
			val partB = it.slice(((it.length / 2))..it.length -1)

			// find duplicate item
			var duplicateItem = "0"
			var j = 0
			while(duplicateItem.equals("0")) {
				if (partB.contains(partA[j])) {
					duplicateItem = partA[j].toString()
				} else {
					j++
				}
			}

			// add to total score
			score += itemValues[duplicateItem]!!
		}

        return score
    }

    fun part2(input: List<String>): Int {

		var score = 0
		var j = 0
		var inventories = ArrayList<String>()

		// processing input
		// break into groups of 3
		while (j < input.size) {
			if (j % 3 != 0) {
				inventories.add(input[j])
				j++
			} else {
				inventories = ArrayList<String>()
				inventories.add(input[j])
				j++

			}

			// find common item
			var commonItem = "0"
			if (inventories.size == 3) {
				inventories[0].forEach {
					if (inventories[1].contains(it) && inventories[2].contains(it)) {
						commonItem = it.toString()
					}
				}

				// calculate score
				score += itemValues[commonItem]!!
			}
		}

        return score
    }

    // test if implementation meets criteria from the description, like:
//    val testInput = readInput("Day01_test")
//    check(part1(testInput) == 1)

    val input = readInput("input_3a")
    println(part1(input))
    println(part2(input))
}
