package AoC2022

import org.scalatest.funsuite.AnyFunSuite

class Day05Suite extends AnyFunSuite {
  val test_data: String = io.Source.fromResource("AoC2022/Day05.input").mkString
  val final_data: String = io.Source.fromFile("./src/main/resources/AoC2022/Day05.input").mkString
  test("Part1 sample input") {
    assert(Day05.part1(test_data) == "CMZ")
  }

  test("Part2 sample input") {
    assert(Day05.part2(test_data) == "MCD")
  }

  test("Part1 final input") {
    assert(Day05.part1(final_data) == "ZWHVFWQWW")
  }

  test("Part2 final input") {
    assert(Day05.part2(final_data) == "HZFZCCWWV")
  }

  }