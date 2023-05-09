package AoC2022

import org.scalatest.funsuite.AnyFunSuite

class Day07Suite extends AnyFunSuite {
  val test_data: Seq[String] = io.Source.fromResource("AoC2022/Day07.input").getLines.toSeq
  val final_data: Seq[String] = io.Source.fromFile("./src/main/resources/AoC2022/Day07.input").getLines.toSeq

  test("Part1 sample input") {
    assert(Day07.part1(test_data) == 95437)
  }

  test("Part2 sample input") {
    assert(Day07.part2(test_data) == 24933642)
  }

  test("Part1 final input") {
    assert(Day07.part1(final_data) == 1297159)
  }

  test("Part2 final input") {
    assert(Day07.part2(final_data) == 3866390)
  }

  }