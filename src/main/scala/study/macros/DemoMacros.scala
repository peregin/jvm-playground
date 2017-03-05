package study.macros

import scala.language.experimental.macros
import scala.reflect.macros.blackbox


object DemoMacros {

  def hoi(): Unit = macro hoiImpl

  def hoiImpl(c: blackbox.Context)(): c.Expr[Unit] = {
    import c.universe._
    reify { println("Hoi!") }
  }

  def debug(param: Any): Unit = macro debug_impl

  def debug_impl(c: blackbox.Context)(param: c.Expr[Any]): c.Expr[Unit] = {
    import c.universe._
    val paramRep = show(param.tree)
    val paramRepTree = Literal(Constant(paramRep))
    val paramRepExpr = c.Expr[String](paramRepTree)
    reify { println(paramRepExpr.splice + " = " + param.splice) }
  }
}
