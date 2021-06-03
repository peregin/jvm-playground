package study.alg.generic

object UniqueEmails extends App {

  def numUniqueEmails(emails: Array[String]): Int = {
    val filtered = emails.map { e =>
      e.split('@') match {
        case Array(local, domain, _*) => s"${local.split('+')(0).filter(_ != '.')}@$domain"
        case other => other
      }
    }
    filtered.distinct.size
  }

  val uniq = numUniqueEmails(Array("a@leetcode.com", "b@leetcode.com", "c@leetcode.com", "c+x@leetcode.com"))
  println(s"emails: $uniq")
}
