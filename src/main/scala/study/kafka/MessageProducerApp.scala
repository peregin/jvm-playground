package study.kafka

import java.util.Properties

import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}

object MessageProducerApp extends App {

  val props = new Properties()
  props.put("bootstrap.servers", "192.168.0.31:9092")
  props.put("client.id", "ScalaProducerExample")
  props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
  props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")
  val producer = new KafkaProducer[String, String](props)
  val data = new ProducerRecord[String, String]("test", "key1", "message")

  println("sending ...")
  producer.send(data)
  producer.close()
  println("message has been sent")
}
