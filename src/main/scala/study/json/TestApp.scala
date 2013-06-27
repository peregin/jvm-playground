package study.json


case class Payload(id: Int, name: String) {

  val anotherField: Long = 12

  val ignoreThisField = "hello"
}

object JsonHelper {

}

object TestApp extends App {


}
