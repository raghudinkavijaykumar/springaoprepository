package com.example.spingaoprepository;

import com.example.spingaoprepository.serializable.PipelineConfigurer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpingAopRepositoryApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpingAopRepositoryApplication.class, args);
	}

	public void run(String[] args) {
		PipelineConfigurer pipelineConfigurer = new PipelineConfigurer();
		pipelineConfigurer.initialize();
	}

}
