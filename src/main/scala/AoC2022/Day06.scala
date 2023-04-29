package AoC2022

import scala.annotation.tailrec

object Day06 {

  def findIndex(input: String, n: Int): Int = input.sliding(n).indexWhere(_.toSet.size == n) + n

  def part1(input: String): Int = findIndex(input, 4)
  def part2(input: String): Int = findIndex(input, 14)

  def main(args: Array[String]) = {
    val data: String = io.Source.fromResource("AoC2022/Day06.input").mkString
    println("Part one: " + part1(data))
    println("Part two: " + part2(data))
  }

}
