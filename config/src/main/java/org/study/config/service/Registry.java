package org.study.config.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class Registry {
	
	@Autowired
	private Environment environment;
	public String getDBHost() {
		return environment.getProperty("db-host");
	}
	
}
