package org.study.consumer.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {
	
	@Autowired
	private WorkerClient worker;

	@KafkaListener(topics = "books", groupId = "consumer-group")
    public void consume(String message) throws IOException {
        System.out.println("Message --> "+message);
        System.out.println(worker.callWorker(message));
    }
	
}
