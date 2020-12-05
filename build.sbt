import sbt.Keys.libraryDependencies

organization := "peregin.com"

name := "jvm-playground"

version := "1.0.0-SNAPSHOT"

scalaVersion := "2.13.4"

javacOptions ++= List("-source", "1.8", "-target", "1.8")

scalacOptions ++= List("-target:jvm-1.8", "-feature", "-deprecation", "-language:implicitConversions", "utf-8")

val scalazVersion = "7.3.2"

libraryDependencies += "org.scala-lang" % "scala-reflect" % scalaVersion.value

libraryDependencies += "org.scala-lang" % "scala-swing" % "2.11.0-M7"

libraryDependencies += "com.typesafe.akka" % "akka-actor_2.10" % "2.3.16"

libraryDependencies += "org.swinglabs" % "swingx-core" % "1.6.2-2"

libraryDependencies += "com.jgoodies" % "looks" % "2.2.0"

libraryDependencies += "com.jgoodies" % "jgoodies-common" % "1.8.1"

libraryDependencies += "org.json4s" %% "json4s-jackson" % "3.6.10"

libraryDependencies += "io.reactivex.rxjava2" % "rxjava" % "2.2.20"

libraryDependencies += "io.reactivex" % "rxscala_2.12" % "0.27.0"

libraryDependencies += "org.apache.kafka" % "kafka_2.12" % "2.3.1"

libraryDependencies += "org.specs2" %% "specs2-core" % "4.8.3" % "test"

dependencyOverrides += "com.fasterxml.jackson.core" % "jackson-core" % "2.8.7"

dependencyOverrides += "com.fasterxml.jackson.core" % "jackson-databind" % "2.8.7"

dependencyOverrides += "com.fasterxml.jackson.module" % "jackson-module-scala_2.11" % "2.8.7"

libraryDependencies += "org.scalaz" %% "scalaz-core" % scalazVersion

