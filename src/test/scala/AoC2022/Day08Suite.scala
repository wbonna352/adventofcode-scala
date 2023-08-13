package AoC2022

import org.scalatest.funsuite.AnyFunSuite

class Day08Suite extends AnyFunSuite {
  val test_data: Seq[String] = io.Source.fromResource("AoC2022/Day08.input").getLines.toSeq
  val final_data: Seq[String] = io.Source.fromFile("./src/main/resources/AoC2022/Day08.input").getLines.toSeq

  test("Part1 sample input") {
    assert(Day08.part1(test_data) == 21)
  }

  test("Part2 sample input") {
    assert(Day08.part2(test_data) == 8)
  }

  test("Part1 final input") {
    assert(Day08.part1(final_data) == 1703)
  }

  test("Part2 final input") {
    assert(Day08.part2(final_data) == 496650)
  }

  }