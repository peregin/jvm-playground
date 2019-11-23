package study.kafka

import java.util.{Collections, Properties}

import org.apache.kafka.clients.consumer.KafkaConsumer
import org.apache.kafka.common.serialization.StringDeserializer

import scala.jdk.CollectionConverters._

object MessageConsumerApp extends App with ConnectivityDetails {

  val props = new Properties()
  props.put("group.id", "KafkaConsumerExample")
  props.put("bootstrap.servers", bootstrapServers)
  props.put("key.deserializer", classOf[StringDeserializer].getCanonicalName)
  props.put("value.deserializer", classOf[StringDeserializer].getCanonicalName)

  val consumer = new KafkaConsumer[String, String](props)
  consumer.subscribe(Collections.singletonList(testTopicName))
  println("consumer has been subscribed ...")

  var gameOver = false
  while (!gameOver) {
    val records = consumer.poll(1000)
    //println(s"got ${records.count()} records ...")
    records.iterator().asScala.map { record =>
      println(s"got $record")
      if (record.value() == "quit") gameOver = true
    }
  }

  println("done")
}
