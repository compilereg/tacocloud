package edu.aast.cndc.tacocloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ConfigurationScan(basePackages = {"configs"})
@ComponentScan(basePackages = {"controllers","components","configs"})
public class TacocloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(TacocloudApplication.class, args);
	}

}
