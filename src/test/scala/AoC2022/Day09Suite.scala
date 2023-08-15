package AoC2022

import org.scalatest.funsuite.AnyFunSuite

class Day09Suite extends AnyFunSuite {
  val test_data: Seq[String] = io.Source.fromResource("AoC2022/Day09.input").getLines.toSeq
  val final_data: Seq[String] = io.Source.fromFile("./src/main/resources/AoC2022/Day09.input").getLines.toSeq

  test("Part1 sample input") {
    assert(Day09.part1(test_data) == 13)
  }

  test("Part2 sample input") {
    assert(Day09.part2(test_data) == 8)
  }

  test("Part1 final input") {
    assert(Day09.part1(final_data) == 36)
  }

  test("Part2 final input") {
    assert(Day09.part2(final_data) == 2557)
  }

  }