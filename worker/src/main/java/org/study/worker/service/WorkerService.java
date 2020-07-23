package org.study.worker.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkerService {
	
	@RequestMapping(value="work",consumes = "application/json")
	public Map<String,String> doWork(@RequestBody String message){
		Map<String,String> resp = new HashMap<String,String>();
		System.out.println("**********************************");
		System.out.println("Got order for :"+message);
		System.out.println("**********************************");
		return resp;
	}
}
