package AoC2022

object Day03 {

  val charMap: Map[Char, Int] = (('a' to 'z') zip (1 to 26)).toMap ++ (('A' to 'Z') zip (27 to 52)).toMap

  def part1(input: Seq[String]): Int = input
    .map(line => line.splitAt(line.length / 2))
    .map(line => line._1.toSet & line._2.toSet)
    .map(_.head)
    .map(charMap)
    .sum

  def part2(input: Seq[String]): Int = input
    .grouped(3)
    .map(_.map(_.toSet).reduce(_ & _).head)
    .map(charMap)
    .sum

  def main(args: Array[String]): Unit = {
    val data: Seq[String] = io.Source.fromResource("AoC2022/Day03.input").getLines.toSeq
    println("Part one: " + part1(data))
    println("Part two: " + part2(data))
  }

}
