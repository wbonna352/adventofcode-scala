package AoC2022

import org.scalatest.funsuite.AnyFunSuite

class Day01Suite extends AnyFunSuite {
  val test_data: String = io.Source.fromResource("AoC2022/Day01.input").mkString
  test("Part1 sample input") {
    assert(Day01.part1(test_data) == 24000)
  }

  test("Part2 sample input") {
    assert(Day01.part2(test_data) == 45000)
  }

  test("Part1 final input") {
    val data: String = io.Source.fromFile("./src/main/resources/AoC2022/Day01.input").mkString
    assert(Day01.part1(data) == 72511)
  }

  test("Part2 final input") {
    val data: String = io.Source.fromFile("./src/main/resources/AoC2022/Day01.input").mkString
    assert(Day01.part2(data) == 212117)
  }

  }