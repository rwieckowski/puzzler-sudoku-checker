package pl.rawie.puzzler.sudoku

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

class SudokuCheckSpec extends FlatSpec with ShouldMatchers {
  def test(s: String): Boolean = {
    val rows = s.trim.split('\n')
    val board = rows.map(_.map(_ - '0').toArray).toArray
    check(board)
  }

  "Sudoku check" should "check rows" in {
    test(
      """
        |123156789
        |456789123
        |789423456
        |234567891
        |567891234
        |891234567
        |345678912
        |678912345
        |912345678
      """.stripMargin) should equal(false)
  }

  it should "check cols" in {
    test(
      """
        |123456789
        |456789123
        |789123456
        |234567892
        |567891234
        |891234567
        |345678912
        |678912345
        |912345678
      """.stripMargin) should equal(false)
  }

  it should "check boxes" in {
    test(
      """
        |123456789
        |234567891
        |345678912
        |456789123
        |567891234
        |678912345
        |789123456
        |891234567
        |912345678
      """.stripMargin) should equal(false)
  }

  it should "check all" in {
    test(
      """
        |123456789
        |456789123
        |789123456
        |234567891
        |567891234
        |891234567
        |345678912
        |678912345
        |912345678
      """.stripMargin) should equal(true)
  }
}
