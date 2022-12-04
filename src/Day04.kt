import kotlin.math.min
import kotlin.math.max


fun main() {

    fun part1(input: List<String>): Int {

        var nestedRegions = 0

        input.forEach {
            //split into two
            val elves = it.split(",")

            // break down into the range for each elf
            var elfRegion1 = (elves[0].split("-")[0]).toInt()..(elves[0].split("-")[1]).toInt()
            var elfRegion2 = (elves[1].split("-")[0]).toInt()..(elves[1].split("-")[1]).toInt()

            // if the max of elfRange1 is greater than max elfRange2
            if(elfRegion1.endInclusive.compareTo(elfRegion2.endInclusive) >= 0 &&
                // AND min of elfRange1 is less than min of elfRange2
                elfRegion1.start.compareTo(elfRegion2.start) <= 0 ||
                // OR max of elfRange2 is greater than max of elfRange1
                elfRegion2.endInclusive.compareTo(elfRegion1.endInclusive) >= 0 &&
                // AND min of elfRange2 is less than min of elfRange1
                elfRegion2.start.compareTo(elfRegion1.start) <= 0) {
                nestedRegions += 1
            }
        }

        return nestedRegions
    }

    fun part2(input: List<String>): Int {

        var overlappingRegions = 0

        input.forEach {
            //split into two
            val elves = it.split(",")

            // break down into the range for each elf
            var elfRegion1 = (elves[0].split("-")[0]).toInt()..(elves[0].split("-")[1]).toInt()
            var elfRegion2 = (elves[1].split("-")[0]).toInt()..(elves[1].split("-")[1]).toInt()

            // if elfRange1 contains the max elfRange2
            if((elfRegion1.contains(elfRegion2.endInclusive)) or
                // OR elfRange1 contains the min of elfRange2
                (elfRegion1.contains(elfRegion2.start)) or
                // OR elfRange2 contains the max of elfRange1
                (elfRegion2.contains(elfRegion1.endInclusive)) or
                // OR elfRange2 contains the min of elfRange1
                (elfRegion2.contains(elfRegion1.start)))
            {
                overlappingRegions += 1
            }
        }

        return overlappingRegions
    }

    // testing compareTo
    println((4..4).endInclusive.compareTo((3..5).endInclusive))
    println((3..5).endInclusive.compareTo((4..4).endInclusive))
    println((4..4).start.compareTo((3..5).start))
    println((3..5).start.compareTo((4..4).start))

    val input = readInput("input_4")
    println(part1(input))
    println(part2(input))
}
