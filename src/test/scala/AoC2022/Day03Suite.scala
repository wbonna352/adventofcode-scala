package AoC2022

import org.scalatest.funsuite.AnyFunSuite

class Day03Suite extends AnyFunSuite {
  val test_data: Seq[String] = io.Source.fromResource("AoC2022/Day03.input").getLines.toSeq
  test("Part1 sample input") {
    assert(Day03.part1(test_data) == 157)
  }

  test("Part2 sample input") {
    assert(Day03.part2(test_data) == 70)
  }

  test("Part1 final input") {
    val data: Seq[String] = io.Source.fromFile("./src/main/resources/AoC2022/Day03.input").getLines.toSeq
    assert(Day03.part1(data) == 8401)
  }

  test("Part2 final input") {
    val data: Seq[String] = io.Source.fromFile("./src/main/resources/AoC2022/Day03.input").getLines.toSeq
    assert(Day03.part2(data) == 2641)
  }

  }