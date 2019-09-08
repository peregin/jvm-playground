package study.teachfp

import java.util.concurrent.{CountDownLatch, Executors, ThreadFactory, TimeUnit}

import scala.concurrent.{ExecutionContext, Future}
import scala.util.Random

object MemoTest extends App {

  val cache = new scala.collection.mutable.HashMap[Long, Boolean]

  val random = new Random()

  val par = 50
  val max = 100000
  val max2 = max / 2
  val latch = new CountDownLatch(par)
  implicit val ec = ExecutionContext.fromExecutor(Executors.newFixedThreadPool(par, new ThreadFactory {
    override def newThread(r: Runnable): Thread = {
      val t = new Thread(r, "worker")
      t.setDaemon(true)
      t
    }
  }))

  1 to Int.MaxValue foreach { i =>
    Future {
      val key = random.nextInt(max)
      val value = key > max2
      cache.getOrElseUpdate(key, value)
      latch.countDown()
    }
  }

  // wait for all
  println("wait for the workers")
  latch.await(10, TimeUnit.SECONDS)
  println("done...")
}
