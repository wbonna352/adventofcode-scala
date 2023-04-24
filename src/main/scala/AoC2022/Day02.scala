package AoC2022

object Day02 {

  def part1(input: Seq[String]): Int = {
    val pointsMap: Map[String, Int] =
      Seq("", "B X", "C Y", "A Z", "A X", "B Y", "C Z", "C X", "A Y", "B Z")
        .zipWithIndex
        .toMap

    input.map(pointsMap).sum
  }

  def part2(input: Seq[String]): Int = {
    val pointsMap: Map[String, Int] =
      Seq("", "B X", "C X", "A X", "A Y", "B Y", "C Y", "C Z", "A Z", "B Z")
        .zipWithIndex
        .toMap

    input.map(pointsMap).sum
  }

  def main(args: Array[String]): Unit = {
    val data: Seq[String] = io.Source.fromResource("AoC2022/Day02.input").getLines.toSeq
    println("Part one: " + part1(data))
    println("Part two: " + part2(data))
  }

}
