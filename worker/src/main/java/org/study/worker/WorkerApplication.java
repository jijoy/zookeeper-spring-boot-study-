package org.study.worker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class WorkerApplication {

	public static void main(String[] args) {
//		new SpringApplicationBuilder(WorkerApplication.class).web(WebApplicationType.SERVLET).run(args);
		SpringApplication.run(WorkerApplication.class, args);
	}

}
