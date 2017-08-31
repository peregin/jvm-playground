package study.json


case class Payload(id: Int, name: String) {

  val anotherField: Long = 12

  val ignoreThisField = "hello"
}

object TestApp extends App {

  val payload = Payload(1, "name")
  val json = JsonIO.write(payload)
  println(s"json = $json")
  val payload2 = JsonIO.read[Payload](json)
  println(s"payload2 = $payload2")
}
