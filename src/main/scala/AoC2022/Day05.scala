package AoC2022

import scala.util.matching.Regex

object Day05 {

  type Crate = Char
  type Stack = List[Crate]
  type Stacks = Map[Char, Stack]

  case class Move (
    stackFrom: Char,
    stackTo: Char,
    crates: Int
  )

  def movesFromString(input: String): Seq[Move] = {
    val pattern: Regex = new Regex("""move (\d+) from (\d) to (\d)""", "crates", "stackFrom", "stackTo")
    pattern
      .findAllMatchIn(input)
      .map(line => Move(
        stackFrom = line.group("stackFrom")(0),
        stackTo = line.group("stackTo")(0),
        crates = line.group("crates").toInt
      ))
      .toSeq
  }

  def stacksFromString(input: String): Stacks = {
    input
      .split("\n")
      .map(line => (1 to line.length by 4).map(line).toArray)
      .transpose
      .map(_.toList.filter(_ != ' ').reverse)
      .map(stack => (stack.head, stack.tail))
      .toMap
  }

  def parse(input: String): (Stacks, Seq[Move]) = {
    val Array(stacks_input, moves_input) = input.split("\n\n")
    (stacksFromString(stacks_input), movesFromString(moves_input))
  }

  def executeMove(currentStacks: Stacks, move: Move, isMultiCrateMover: Boolean): Stacks = {
    val stackFrom: Stack = currentStacks(move.stackFrom)
    val stackTo: Stack = currentStacks(move.stackTo)
    val stackFromNewCratesCnt: Int = stackFrom.length - move.crates
    val (newStackFrom: Stack, inMover: Stack) = stackFrom.splitAt(stackFromNewCratesCnt)
    val newStackTo: Stack =
      if (isMultiCrateMover) stackTo ++ inMover
      else stackTo ++ inMover.reverse

    currentStacks ++ Map(move.stackFrom -> newStackFrom, move.stackTo -> newStackTo)
  }

  def getTopCrates(stacks: Stacks): String = {
    stacks.toSeq.sortBy(_._1).map(_._2.last).mkString
  }

  def part1(input: String): String = {
    val (initStacks: Stacks, moves: Seq[Move]) = parse(input)
    val finalStacks: Stacks = moves.foldLeft(initStacks)((s, m) => executeMove(s, m, isMultiCrateMover = false))

    getTopCrates(finalStacks)
  }

  def part2(input: String): String = {
    val (initStacks: Stacks, moves: Seq[Move]) = parse(input)
    val finalStacks: Stacks = moves.foldLeft(initStacks)((s, m) => executeMove(s, m, isMultiCrateMover = true))

    getTopCrates(finalStacks)
  }

  def main(args: Array[String]): Unit = {
    val data: String = io.Source.fromResource("AoC2022/Day05.input").mkString
    println("Part one: " + part1(data))
    println("Part two: " + part2(data))



  }
}
