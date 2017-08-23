package study.db

import com.datastax.driver.core.Cluster

object TestApp extends App {

  println("connecting...")

  val cluster = Cluster.builder().addContactPoint("192.168.0.40").build()
  val session = cluster.connect("test")
  session.close()
  cluster.close()
}
