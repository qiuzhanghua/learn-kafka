package com.github.qiuzhanghua

import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.clients.consumer.KafkaConsumer
import org.apache.kafka.common.serialization.StringDeserializer
import java.time.Duration
import java.util.*

fun main() {
    val bootStrapServer = "localhost:9092"
    val groupId = "my-first-app"
    val properites = Properties()
    properites.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootStrapServer)
    properites.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer::class.qualifiedName)
    properites.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer::class.qualifiedName)
    properites.setProperty(ConsumerConfig.GROUP_ID_CONFIG, groupId)
    properites.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest")  //     latest/none

    val consumer = KafkaConsumer<String, String>(properites)
    consumer.subscribe(listOf("first_topic"))

    while(true) {
        val consumerRecords = consumer.poll(Duration.ofMillis(100))
        consumerRecords.records("first_topic").forEach {
            println(it.key())
            println(it.value())
        }
    }
}