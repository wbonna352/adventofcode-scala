package AoC2022

import scala.util.matching.Regex

object Day04 {

  def parse(input: String): Iterator[Array[Int]] = {
    val pattern: Regex = """(\d+)-(\d+),(\d+)-(\d+)""".r
    pattern.findAllMatchIn(input)
      .map(_.subgroups.map(_.toInt).toArray)
  }

  def part1(input: String): Int = {
    parse(input)
      .count(a => (a(0) >= a(2) & a(1) <= a(3)) | (a(2) >= a(0) && a(3) <= a(1)))
  }
  def part2(input: String): Int = {
    parse(input)
      .count(a => (a(0) <= a(3)) & (a(2) <= a(1)))
  }

  def main(args: Array[String]): Unit = {
    val data: String = io.Source.fromResource("AoC2022/Day04.input").mkString
    println("Part one: " + part1(data))
    println("Part two: " + part2(data))
  }
}
