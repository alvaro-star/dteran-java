package br.edu.ifms.estudante.alvaro.detran;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class DetranApplication {

	public static void main(String[] args) {
		SpringApplication.run(DetranApplication.class, args);
	}
	
}