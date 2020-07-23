package org.study.consumer.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
@Configuration
@EnableDiscoveryClient
@EnableFeignClients
public class WorkerClient {

	
	@Autowired
	ThinClient thinClient;
	
	@FeignClient(name="worker")
	interface ThinClient {
		@RequestMapping(value="/work",method=RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody
		Map<String,String> doWork(@RequestBody String request);
	}
	
	
	public Map<String,String> callWorker(String message){
		return thinClient.doWork(message);
	}
	
}
