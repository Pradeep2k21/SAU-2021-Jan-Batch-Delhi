package com.Kafka.Pradeep.Controller;

import com.Kafka.Pradeep.Model.MovieKafka;
import com.Kafka.Pradeep.Producer.kafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
public class kafkaController {

    public static final String TOPIC = "Movie_Topic"; //javainuse-topic

    @Autowired
    kafkaProducer producer;

    @Autowired
    public KafkaTemplate<String, MovieKafka> kafkaTemplate;
    String topic = kafkaController.TOPIC;


    @PostMapping("/addMovie")
    public String postMessage(@RequestBody MovieKafka movie)
    {
        producer.addMovie(movie);
        return movie.getName()+" successfully Published!!";
    }
}
