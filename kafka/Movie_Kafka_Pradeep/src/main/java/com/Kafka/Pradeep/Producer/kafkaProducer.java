package com.Kafka.Pradeep.Producer;

import com.Kafka.Pradeep.Controller.kafkaController;
import com.Kafka.Pradeep.Model.MovieKafka;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


@Component
public class kafkaProducer {

    private static final Logger logger = LoggerFactory.getLogger(KafkaProperties.Producer.class);
    @Autowired
    public KafkaTemplate<String, MovieKafka> kafkaTemplate;

    String topic = kafkaController.TOPIC;

    public void addMovie(MovieKafka movie)
    {
        logger.info(String.format("Producing Movie: %s", movie));
        kafkaTemplate.send(topic,movie);
    }
}
