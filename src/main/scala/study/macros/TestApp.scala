package study.macros

/**
 * Created by levi on 15/02/14.
 */
object TestApp extends App {

  println("test started...")

  import DemoMacros._
  hoi()

  val x = 1
  debug("hello " + x)
}
