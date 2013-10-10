package pl.rawie.puzzler

import scala.Predef._

package object sudoku {
  private val numbers = (1 to 9).toSet
  private val offsets = for (x <- 0 to 2; y <- 0 to 2) yield (x, y)
  private type Slicer = (Int => Seq[Int])

  def check(board: Array[Array[Int]]): Boolean = {
    def row(i: Int): Seq[Int] = board(i)

    def col(i: Int): Seq[Int] = board.map(_(i))

    def block(i: Int): Seq[Int] = {
      val (x, y) = ((i % 3) * 3, (i / 3) * 3)
      offsets.map { case (dx, dy) => board(y + dy)(x + dx) }
    }

    val slices = for (f <- List[Slicer](row, col, block); i <- 0 to 8)
      yield numbers equals(f(i) toSet)

    !slices.contains(false)
  }
}
