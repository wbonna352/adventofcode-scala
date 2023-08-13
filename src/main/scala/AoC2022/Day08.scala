package AoC2022

import scala.annotation.tailrec

object Day08 {

  def parse(input: Seq[String]): Forest[Int] = {
    input.map(_.toCharArray.map(_.asDigit))
  }

  type Forest[A] = Seq[Seq[A]]

  extension [A](forest: Forest[A]) {

    def megaZip[B](secondForest: Forest[B]): Forest[(A, B)] = {
      (forest zip secondForest)
        .map((row1, row2) => row1 zip row2)
    }
    def megaMap[B](f: A => B): Forest[B] = forest.map(_.map(f))
    def pipe[B](f: (forest: Forest[A]) => Forest[B]): Forest[B] = f(forest)
  }

  def forestReduce[A](op: ((A, A)) => A)(f1: Forest[A], f2: Forest[A]): Forest[A] = {
    f1.megaZip(f2).megaMap(op)
  }

  def treesVisibility(row: Seq[Int]): Seq[Boolean] = {
    val maxUntil: Seq[Int] =
      row.scanLeft(-1) {
        case (currMax, nextVal) => if (nextVal > currMax) nextVal else currMax
      }.init

    (row zip maxUntil)
      .map {
        case (tree, max) => tree > max
      }
  }

  def viewingDistance(row: Seq[Int]): Seq[Int] = {
    @tailrec
    def runner(res: Seq[Int], toCount: Seq[Int]): Seq[Int] = {
      if (toCount.isEmpty) res
      else
        val value = toCount match {
          case x => x.tail.indexWhere(_ >= x.head) + 1
        } match {
          case x if x == 0 => toCount.tail.length
          case x => x
        }
        runner(res :+ value, toCount.tail)
    }

    runner(Seq(), row)

  }

  def computeAll[A](input: Forest[Int], func: Seq[Int] => Seq[A]): Seq[Forest[A]] = {
    for {
      reverse <- Seq(true, false)
      transpose <- Seq(true, false)
    } yield {

      input
        .pipe(x => if (transpose) x.transpose else x)
        .pipe(x => if (reverse) x.map(_.reverse) else x)
        .pipe(x => x.map(func))
        .pipe(x => if (reverse) x.map(_.reverse) else x)
        .pipe(x => if (transpose) x.transpose else x)

    }
  }

  def part1(input: Seq[String]): Int = {
    val data: Forest[Int] = parse(input)
    val res: Seq[Forest[Boolean]] = computeAll[Boolean](data, treesVisibility)

    res.reduce(forestReduce(_ | _))
      .flatten
      .count(_ == true)
  }

  def part2(input: Seq[String]): Int =
    val data: Forest[Int] = parse(input)
    val res: Seq[Forest[Int]] = computeAll[Int](data, viewingDistance)

    res.reduce(forestReduce(_ * _))
      .flatten
      .max

  def main(args: Array[String]): Unit = {
   val input: Seq[String] = io.Source.fromResource("AoC2022/Day08.input").getLines().toSeq

    println("Part one: " + part1(input))
    println("Part two: " + part2(input))
  }
}
