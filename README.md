# Spring Boot Kafka Demo application 
This is an example application to show how to create Kafka Consumer in Spring Boot application.

This application uses 2 Kafka topics.
The quickstart-event topic was created with 2 partitions in my test.
The quickstart-multi-event topic was created with 3 partitions in my test.

The number of listener thread is defined in the application.properties file `spring.kafka.listener.concurrency`.
This tells Spring Boot how many threads to use for the listener.  
When there are multiple partitions per topic, multiple threads are used to consume the message.

The following 2 class demonstrated 2 ways to create the listener.
Consumer class relied on Spring Boot to perform all the setup (ConsumerFactory, Listener Container Factory).
ConsumerUsingFactory relied on the ConsumerFactory and ConcurrentKafkaListenerContainerFactory in KafkaConfig.

## Run the Spring Boot app 
`${JAVA_HOME}/bin/java -jar -Dspring.profiles.active=dev ./target/spring-boot-kafka-1.0.0-SNAPSHOT.jar`

Note: there is currently no spring profile defined in this repo.

You can run multiple instances of the demo application.  The web server is disbaled.  
Kafka and Spring Boot should take care of the listeners based on the number of topic partitions in Kafka and the number of app instances running.

## To Send test message to a Kafka topic on local Kafka
${KAFKA_HOME}/bin/kafka-console-producer.sh --topic quickstart-events --bootstrap-server localhost:9092

See this page for setup local Kafka and send text message to topic.
https://kafka.apache.org/quickstart
