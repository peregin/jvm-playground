import sbt.Keys.libraryDependencies

organization := "peregin.com"

name := "jvm-playground"

version := "1.0.0-SNAPSHOT"

scalaVersion := "2.12.8"

javacOptions ++= List("-source", "1.8", "-target", "1.8")

scalacOptions ++= List("-target:jvm-1.8", "-feature", "-deprecation", "-language:implicitConversions", "utf-8")

libraryDependencies += "org.specs2" %% "specs2-core" % "4.5.1" % "test"



