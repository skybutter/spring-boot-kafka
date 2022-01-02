package alan.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * This class uses a user defined ConcurrentKafkaListenerContainerFactory.
 */
@Service
public class ConsumerUsingFactory {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ConsumerUsingFactory.class);

    @Value("${topic.quickstart-multi-events}")
    private String topicName;

    @KafkaListener(topics = "${topic.quickstart-multi-events}", containerFactory = "kafkaListenerContainerFactory")
    public void consume(ConsumerRecord<String, String> payload){
        log.info("topic:{}, key:{}, partition:{}, value:{}", topicName, payload.key(), payload.partition(), payload.value());
    }

}
