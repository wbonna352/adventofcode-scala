package AoC2022

import org.scalatest.funsuite.AnyFunSuite

class Day04Suite extends AnyFunSuite {
  val test_data: String = io.Source.fromResource("AoC2022/Day04.input").mkString
  val final_data: String = io.Source.fromFile("./src/main/resources/AoC2022/Day04.input").mkString
  test("Part1 sample input") {
    assert(Day04.part1(test_data) == 2)
  }

  test("Part2 sample input") {
    assert(Day04.part2(test_data) == 4)
  }

  test("Part1 final input") {
    assert(Day04.part1(final_data) == 651)
  }

  test("Part2 final input") {
    assert(Day04.part2(final_data) == 956)
  }

  }