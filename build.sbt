import sbt.Keys.libraryDependencies

organization := "peregin.com"

name := "jvm-playground"

version := "1.0.0-SNAPSHOT"

scalaVersion := "2.11.11"

javacOptions ++= List("-source", "1.8", "-target", "1.8")

scalacOptions ++= List("-target:jvm-1.8", "-feature", "-deprecation", "-language:implicitConversions", "utf-8")

seq(groovy.settings :_*)

seq(testGroovy.settings :_*)

libraryDependencies += "org.scala-lang" % "scala-reflect" % "2.11.11"

libraryDependencies += "org.scala-lang" % "scala-swing" % "2.11.0-M7"

libraryDependencies += "com.typesafe.akka" % "akka-actor_2.10" % "2.1.4"

libraryDependencies += "org.swinglabs" % "swingx-core" % "1.6.2-2"

libraryDependencies += "com.jgoodies" % "looks" % "2.2.0"

libraryDependencies += "com.jgoodies" % "jgoodies-common" % "1.8.1"

libraryDependencies += "org.json4s" % "json4s-jackson_2.10" % "3.5.3"

libraryDependencies += "io.reactivex.rxjava2" % "rxjava" % "2.1.3"

libraryDependencies += "org.apache.kafka" % "kafka_2.11" % "0.11.0.0"

libraryDependencies += "com.datastax.cassandra" % "cassandra-driver-core" % "3.3.0"

libraryDependencies += "org.specs2" %% "specs2" % "3.7" % "test"

libraryDependencies += "io.reactivex" %% "rxscala" % "0.26.5"

