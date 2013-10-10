import sbt._
import sbt.Keys._

object PuzzlerSudokuCheckerBuild extends Build {

  lazy val puzzlerSudokuChecker = Project(
    id = "puzzler-sudoku-checker",
    base = file("."),
    settings = Project.defaultSettings ++ Seq(
      name := "Puzzler Sudoku Checker",
      organization := "pl.rawie.puzzler.sudoku",
      version := "0.1-SNAPSHOT",
      scalaVersion := "2.10.2",
      libraryDependencies ++= Seq(
        "org.scalatest" %% "scalatest" % "1.9.2" % "test"
      )	
      // add other settings here
    )
  )
}
