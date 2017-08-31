package study.bb

import java.io.FileWriter

import study.json.JsonIO

import scala.util.Random

object TravelApp extends App {

  val json = (0 to 100).map{ix =>
    Travel(s"name$ix", 20 + Random.nextInt(5), 25 + 10 * Random.nextDouble())
  }.map(JsonIO.write).mkString("\n")
  val writer = new FileWriter("travel.json")
  writer.write(json)
  writer.close()
}
