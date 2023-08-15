package AoC2022

object Day09 {

  import Direction.*

  enum Direction:
    case U, D, L, R

  case class Motion(direction: Direction, steps: Int) {
    def moves: Seq[Direction] = Seq.fill(steps)(direction)
  }

  def parse(input: Seq[String]): Seq[Motion] = {
    input.map(
      line =>
        val s"$d $n" = line : @unchecked
        Motion(Direction.valueOf(d), n.toInt)
    )
  }

  case class Position(x: Int = 0, y: Int = 0) {
    def move(direction: Direction): Position = {
      direction match {
        case U => Position(x, y + 1)
        case D => Position(x, y - 1)
        case L => Position(x - 1, y)
        case R => Position(x + 1, y)
      }
    }

    def planckFollow(head: Position): Position = {
      val dx = head.x - x
      val dy = head.y - y

      if (dx.abs > 1 || dy.abs > 1) Position(x + dx.sign, y + dy.sign)
      else this
    }
  }

  case class Rope(head: Position, tail: Position) {
    def planckMove(direction: Direction): Rope = {
      val newHead = head.move(direction)
      val newTail = tail.planckFollow(newHead)
      Rope(newHead, newTail)
    }
  }

  def part1(input: Seq[String]): Int = {
    val motions = parse(input)
    val moves = motions.flatMap(_.moves)
    val start = Rope(Position(), Position())

    val finalRope = moves.scanLeft(start)((rope: Rope, d: Direction) => rope.planckMove(d))
    finalRope.map(_.tail).distinct.length
  }

  def main(args: Array[String]): Unit = {
    val input: Seq[String] = io.Source.fromResource("AoC2022/Day09.input").getLines().toSeq

    println("Part one: " + part1(input))

  }


}
