package org.study.producer.service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.study.producer.service.config.AppConfig;

@RestController
public class ProducerService {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@Autowired
	private AppConfig config;
	
	@PostMapping(value="order",produces = "application/json")
	public Map<String,String> placeAnOrder() throws InterruptedException, ExecutionException{
		Map<String,String> response = new HashMap<String,String>();

		ListenableFuture<SendResult<String,String>> res =  kafkaTemplate.send(config.getTopic(), "order");
		response.put("status", res.get().getProducerRecord().value());
		return response;
	}
 	
	
}
