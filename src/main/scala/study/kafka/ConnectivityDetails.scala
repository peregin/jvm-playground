package study.kafka

trait ConnectivityDetails {

  //val bootstrapServers = "192.168.0.31:9092,192.168.0.32:9092,192.168.0.33:9092"
  val bootstrapServers = "192.168.0.22:9092"
  val zookeeperServers = "192.168.0.22:2181"
  val testTopicName = "x8-topic"
}
