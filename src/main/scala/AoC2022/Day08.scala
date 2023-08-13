package AoC2022

object Day08 {

  type forest[A] = Seq[Seq[A]]

  def parse(input: Seq[String]): forest[Int] = {
    input.map(_.toCharArray.map(_.asDigit))
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

  def computeAll[A](input: forest[Int], func: Seq[Int] => Seq[A]): Seq[forest[A]] = {
    for {
      reverse <- Seq(true, false)
      transpose <- Seq(true, false)
    } yield {
      val arr = if (transpose) input.transpose else input
      val arr_r = if (reverse) arr.map(_.reverse) else arr
      val res = arr_r.map(func)
      val final1 = if (reverse) res.map(_.reverse) else res
      val final2 = if (transpose) final1.transpose else final1

      final2
    }
  }

  def reduceForest(f1: forest[Boolean], f2: forest[Boolean]): forest[Boolean] = {
    (f1 zip f2)
      .map {
        case (row1, row2) =>
          (row1 zip row2)
            .map {
              case (tree1, tree2) =>
                tree1 | tree2
            }
      }
  }

  def countVisibleTrees(forest: forest[Boolean]): Int = {
    forest
      .map(row =>
        row.map(tree => if (tree) 1 else 0)
      )
      .map(row => row.sum)
      .sum
  }

  def main(args: Array[String]): Unit = {
   val input: Seq[String] = io.Source.fromResource("AoC2022/Day08.input").getLines().toSeq
// val input: Seq[String] = io.Source.fromResource("AoC2022/Day08Test.input").getLines().toSeq

    val data = parse(input)

    val res: Seq[forest[Boolean]] = computeAll[Boolean](data, treesVisibility)

    val finalForest = res.reduce(reduceForest)

    val part1 = countVisibleTrees(finalForest)

    println(part1)






  }

}
