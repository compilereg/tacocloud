package edu.aast.cndc.tacocloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"controllers"})
public class TacocloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(TacocloudApplication.class, args);
	}

}
