package AoC2022

object Day01 {

  def parse(input: String): Seq[Int] = {
    input
      .split("\n\n")
      .map(_
        .split("\n")
        .map(_.toInt)
        .sum
      )
      .toSeq
  }

  def part1(input: String): Int = parse(input).max
  def part2(input: String): Int = parse(input).sorted.takeRight(3).sum

  def main(args: Array[String]): Unit = {
    val data: String = io.Source.fromFile("./src/main/resources/AoC2022/Day01.input").mkString

    println("Part1: " + part1(data))
    println("Part2: " + part2(data))
  }
}
