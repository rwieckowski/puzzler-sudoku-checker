package pl.rawie.puzzler

import scala.Predef._

package object sudoku {
  private val numbers = (1 to 9).toSet
  private val offsets = for (x <- 0 to 2; y <- 0 to 2) yield (x, y)

  private class SudokuSeq(s: Seq[Int]) {
    def isValid: Boolean = numbers.intersect(s.toSet).size == 9
  }

  private implicit def seqToSudokuSeq(s: Seq[Int]) = new SudokuSeq(s)

  def check(board: Array[Array[Int]]): Boolean = {
    def row(i: Int): Seq[Int] = board(i)

    def col(i: Int): Seq[Int] = board.map(_(i))

    def box(i: Int): Seq[Int] = {
      val (x, y) = ((i % 3) * 3, (i / 3) * 3)
      offsets.map(o => board(y + o._1)(x + o._2))
    }

    (0 to 8)
      .map(i => row(i).isValid && col(i).isValid && box(i).isValid)
      .find(!_)
      .isEmpty
  }
}
