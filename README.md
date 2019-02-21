# Learn-Kafka
learn Kafka with Kotlin and Gradle

## Install Kafka
1. install JDK 8
2. download kafka_2.12-2.1.1.tgz, and


```bash
cd /opt
tar zxvf kafka_2.12-2.1.1.tgz
ln -s kafka_2.12-2.1.1 kafka

cd /data
mkdir zookeeper
mkdir kafka
mkdir config
cd config
cp /opt/kafka/config/zookeeper.properties .
cp /opt/kafka/config/server.properties .

```

3. add "export PATH=$PATH:/opt/kafka/bin" to the end of .bash_profile

4. modify /data/config/zookeeper.properties as
   ```
   dataDir=/data/zookeeper
   ```
5. modify /data/config/server.properties as
   ```
    log.dirs=/data/kafka
   ```

## Run Kafka

```bash
zookeeper-server-start.sh /data/config/zookeeper.properties

kafka-server-start.sh /data/config/server.properties
```