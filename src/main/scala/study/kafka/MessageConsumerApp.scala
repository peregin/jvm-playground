package study.kafka

import java.util.{Collections, Properties}

import org.apache.kafka.clients.consumer.KafkaConsumer
import org.apache.kafka.common.serialization.StringDeserializer

import collection.JavaConversions._

object MessageConsumerApp extends App with ConnectivityDetails {

  val props = new Properties()
  props.put("group.id", "KafkaConsumerExample")
  props.put("bootstrap.servers", bootstrapServers)
  props.put("key.deserializer", classOf[StringDeserializer].getCanonicalName)
  props.put("value.deserializer", classOf[StringDeserializer].getCanonicalName)

  val consumer = new KafkaConsumer[String, String](props)
  consumer.subscribe(Collections.singletonList(testTopicName))
  println("consumer has been subscribed ...")

  (1 to 100).foreach { i =>
    val records = consumer.poll(1000)
    println(s"got ${records.count()} records ...")
    records.map { record =>
      println(s"got $record")
    }
  }

  println("done")
}
