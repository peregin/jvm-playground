package study.alg.generic

object ListReplication extends App {

  def f(num:Int,arr:List[Int]):List[Int] = arr.flatMap(a => List.fill(a)(num))
}
