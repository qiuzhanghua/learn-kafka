package com.github.qiuzhanghua

import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.clients.producer.RecordMetadata
import org.apache.kafka.common.serialization.StringSerializer
import java.lang.Exception
import java.util.*


fun main() {
    val properties = Properties()
    properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092")
    properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer::class.qualifiedName)
    properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer::class.qualifiedName)

    val producer = KafkaProducer<String, String>(properties)

    for (i in 0..9) {
        val record = ProducerRecord<String, String>("first_topic", "id_$i", "邱张华")
        producer.send(record) { recordMetadata: RecordMetadata?, exception: Exception? ->
            if (exception == null) {
                with(recordMetadata!!) {
                    println(topic())
                    println(partition())
                    println(offset())
                    println(timestamp())
                }
            } else {
                println(exception)
            }
        }
    }
    producer.close()

}