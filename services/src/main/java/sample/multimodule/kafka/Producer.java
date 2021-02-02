/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.multimodule.kafka;

import io.confluent.kafka.serializers.KafkaAvroSerializer;
import java.util.Properties;
import lombok.extern.apachecommons.CommonsLog;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author brijeshdhaker
 */
@Service
@CommonsLog(topic = "Producer Logger")
public class Producer {

    @Value("${topic.name}")
    private String TOPIC;
    private static int counter = 0;
    private final KafkaTemplate<String, User> kafkaTemplate;
    
    @Autowired
    public Producer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(User user) {
        
        this.kafkaTemplate.send(this.TOPIC, user.getName(), user);
        log.info(String.format("Produced user -> %s", user));
        
    }
    
    public void processMessage(User user) {
        
        //this.kafkaTemplate.send(this.TOPIC, user.getName(), user);
        
        Properties properties = new Properties();
        // Kafka Properties
        properties.setProperty("bootstrap.servers", "broker:9092");
        properties.setProperty("acks", "all");
        properties.setProperty("retries", "10");
        // Avro properties
        properties.setProperty("key.serializer", StringSerializer.class.getName());
        properties.setProperty("value.serializer", KafkaAvroSerializer.class.getName());
        properties.setProperty("schema.registry.url", "http://schema-registry:8081");

        KafkaProducer<String, User> producer = new KafkaProducer<String, User>(properties);
        
        String key = "id_"+counter++;
        ProducerRecord<String, User> producerRecord = new ProducerRecord<String, User>(TOPIC, key, user);
        producer.send(producerRecord, new Callback() {
            @Override
            public void onCompletion(RecordMetadata metadata, Exception exception) {
                if (exception == null) {
                    log.info("Successfully received the details as: \n" +  
                    "Topic:" + metadata.topic() + "\n" +  
                    "Partition:" + metadata.partition() + "\n" +  
                    "Offset" + metadata.offset() + "\n" +  
                    "Timestamp" + metadata.timestamp());  
                } else {
                    log.error(exception.getMessage());
                }
            }
        });

        producer.flush();
        producer.close();
            
        log.info(String.format("Produced user -> %s", user));
    }
}
