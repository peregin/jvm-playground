package study.kafka

import java.util.Properties
import java.util.concurrent.TimeUnit

import org.apache.kafka.clients.producer._
import org.apache.kafka.common.serialization.StringSerializer

object MessageProducerApp extends App with ConnectivityDetails {

  val props = new Properties()
  props.put("client.id", "KafkaProducerExample")
  props.put("producer.type", "async")
  props.put("acks", "all")
  props.put("batch.size", "1")
  props.put("linger.ms", "500")
  props.put("request.timeout.ms", "10000")
  props.put("bootstrap.servers", bootstrapServers)
  props.put("key.serializer", classOf[StringSerializer].getCanonicalName)
  props.put("value.serializer", classOf[StringSerializer].getCanonicalName)
  val producer = new KafkaProducer[String, String](props)
  val data = new ProducerRecord[String, String](testTopicName, "message")

  println("sending ...")
  val fut = producer.send(data, new Callback {
    override def onCompletion(metadata: RecordMetadata, exception: Exception) {
      println("completion")
      Option(exception).foreach(_.printStackTrace())
      Option(metadata).foreach(println)
    }
  })
  producer.flush()
  println(s"sent $fut")

  producer.close(1, TimeUnit.SECONDS)
  println("done")
}
