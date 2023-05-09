package AoC2022

import scala.util.matching.Regex

object Day07 {

  def calculateDirSizes(input: Seq[String]): Map[String, Int] = {

    val newDirPattern: Regex = """\$ cd ([/\w]+)""".r
    val newFilePattern: Regex = """(\d+) [\w\.]+""".r

    def dirSize(dirName: String, lines: Seq[String], currentSize: Int, endedNeeded: Int): List[(String, Int)] = {

      if (endedNeeded == 0 | lines.isEmpty) List((dirName, currentSize))
      else {
        lines.head match {
          case newDirPattern(x) =>
            if (endedNeeded == 1) dirSize(dirName, lines.tail, currentSize, endedNeeded+1) ++ dirSize(dirName + "/" + x, lines.tail, 0, 1)
            else dirSize(dirName, lines.tail, currentSize, endedNeeded+1)
          case "$ cd .." => dirSize(dirName, lines.tail, currentSize, endedNeeded-1)
          case newFilePattern(x) => dirSize(dirName, lines.tail, currentSize + x.toInt, endedNeeded)
          case _ => dirSize(dirName, lines.tail, currentSize, endedNeeded)
        }
      }
    }

    dirSize(
      dirName = "/",
      lines = input.tail,
      currentSize = 0,
      endedNeeded = 1
    ).toMap

  }

  def part1(input: Seq[String]): Int = {
    calculateDirSizes(input)
      .values
      .filter(_ <= 100000)
      .sum
  }

  def part2(input: Seq[String]): Int = {
    val pathSizes: Map[String, Int] = calculateDirSizes(input)
    val sizeToFreeUp = pathSizes("/") - (70000000 - 30000000)
    pathSizes
      .values
      .filter(_ >= sizeToFreeUp)
      .min
  }

  def main(args: Array[String]): Unit = {
    val data = io.Source.fromResource("AoC2022/Day07.input").getLines.toSeq

    println("Part one: " + part1(data))
    println("Part two: " + part2(data))
  }
}
