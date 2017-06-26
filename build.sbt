import sbt.Keys.libraryDependencies

organization := "peregin.com"

name := "jvm-playground"

version := "1.0.0-SNAPSHOT"

scalaVersion := "2.11.11"

javacOptions ++= List("-source", "1.8", "-target", "1.8")

scalacOptions ++= List("-target:jvm-1.8", "-feature", "-deprecation", "-language:implicitConversions", "utf-8")

libraryDependencies += "org.scala-lang" % "scala-reflect" % "2.11.8"

libraryDependencies += "org.scala-lang" % "scala-swing" % "2.11.0-M7"

libraryDependencies += "com.typesafe.akka" % "akka-actor_2.10" % "2.1.4"

libraryDependencies += "org.swinglabs" % "swingx-core" % "1.6.2-2"

libraryDependencies += "com.jgoodies" % "looks" % "2.2.0"

libraryDependencies += "com.jgoodies" % "jgoodies-common" % "1.4.0"

libraryDependencies += "org.json4s" % "json4s-jackson_2.10" % "3.2.4"

libraryDependencies += "io.reactivex.rxjava2" % "rxjava" % "2.0.6"

