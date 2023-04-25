package AoC2022

import org.scalatest.funsuite.AnyFunSuite

class Day02Suite extends AnyFunSuite {
  val test_data: Seq[String] = io.Source.fromResource("AoC2022/Day02.input").getLines.toSeq
  val final_data: Seq[String] = io.Source.fromFile("./src/main/resources/AoC2022/Day02.input").getLines.toSeq

  test("Part1 sample input") {
    assert(Day02.part1(test_data) == 15)
  }

  test("Part2 sample input") {
    assert(Day02.part2(test_data) == 12)
  }

  test("Part1 final input") {
    assert(Day02.part1(final_data) == 12679)
  }

  test("Part2 final input") {
    assert(Day02.part2(final_data) == 14470)
  }

  }