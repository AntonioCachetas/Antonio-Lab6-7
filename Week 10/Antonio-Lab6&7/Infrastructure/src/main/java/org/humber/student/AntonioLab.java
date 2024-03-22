package org.humber.student;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class AntonioLab {

	public static void main(String[] args) {
		SpringApplication.run(AntonioLab.class, args);
		log.info("Successfully Started");
	}

}
