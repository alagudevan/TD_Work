ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"


libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.9.4"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.11" % Test


lazy val root = (project in file("."))
  .settings(
    name := "QuadraticEquations"
  )
