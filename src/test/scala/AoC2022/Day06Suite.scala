package AoC2022

import org.scalatest.funsuite.AnyFunSuite

class Day06Suite extends AnyFunSuite {
  val final_data: String = io.Source.fromFile("./src/main/resources/AoC2022/Day06.input").mkString

  test("Part1 test input") {
    assert(Day06.part1("bvwbjplbgvbhsrlpgdmjqwftvncz") == 5)
    assert(Day06.part1("nppdvjthqldpwncqszvftbrmjlhg") == 6)
    assert(Day06.part1("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg") == 10)
    assert(Day06.part1("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw") == 11)
  }

  test("Part2 test input") {
    assert(Day06.part2("mjqjpqmgbljsphdztnvjfqwrcgsmlb") == 19)
    assert(Day06.part2("bvwbjplbgvbhsrlpgdmjqwftvncz") == 23)
    assert(Day06.part2("nppdvjthqldpwncqszvftbrmjlhg") == 23)
    assert(Day06.part2("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg") == 29)
    assert(Day06.part2("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw") == 26)
  }

  test("Part1 final input") {
    assert(Day06.part1(final_data) == 1802)
  }

  test("Part2 final input") {
    assert(Day06.part2(final_data) == 3551)
  }

  }