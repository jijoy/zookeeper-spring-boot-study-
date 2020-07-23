package org.study.config.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ConfigurationProperties()
public class HomeService {

	@Autowired
	Registry registry;
	
	@GetMapping(value="/db-host",produces = "application/json")
	public Map<String,String> getConfig() {
		String dbHost = registry.getDBHost();
		Map<String,String> response= new HashMap<String,String>();
		response.put("host", dbHost);
		return response;
	}
	
	
}
