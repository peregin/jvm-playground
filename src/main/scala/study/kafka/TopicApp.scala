package study.kafka

import kafka.admin.AdminUtils
import kafka.utils.ZkUtils

object TopicApp extends App with ConnectivityDetails {

  println("listing topics ...")

  val zkUtils = ZkUtils(zookeeperServers, 30000, 30000, isZkSecurityEnabled = false)
  val topicNames = zkUtils.getAllTopics()
  println(s"configured topics: \n${topicNames.mkString("\t", ",", "\n")}")

  if (topicNames.find(_.equalsIgnoreCase(testTopicName)).isEmpty) {
    println(s"creating $testTopicName topic ...")
    AdminUtils.createTopic(zkUtils, testTopicName, 1, 1)
    println("topic has been created")
  }

  zkUtils.close()
}
