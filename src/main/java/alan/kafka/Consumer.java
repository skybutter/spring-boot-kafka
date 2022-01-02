package alan.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * This class relies on Spring Boot to set up the ConsumerFactory and the listener container factory.
 */
@Service
public class Consumer {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(Consumer.class);
    @Value("${topic.quickstart-events}")
    private String topicName;

    @KafkaListener(topics = "${topic.quickstart-events}")
    public void consume(ConsumerRecord<String, String> payload){
        log.info("topic:{}, key:{}, partition:{}, value:{}", topicName, payload.key(), payload.partition(), payload.value());
    }
}
