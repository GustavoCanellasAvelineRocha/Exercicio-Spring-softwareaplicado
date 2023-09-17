package br.pucrs.engswii;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages= {"br.pucrs.engswii"})
public class EngswiiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EngswiiApplication.class, args);
	}

}
