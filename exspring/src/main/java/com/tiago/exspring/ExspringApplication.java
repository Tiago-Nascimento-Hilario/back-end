package com.tiago.exspring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExspringApplication implements CommandLineRunner {

	private final TesteRepository testeRepository;

	public ExspringApplication(TesteRepository testeRepository){
		this.testeRepository = testeRepository;
	}


	public static void main(String[] args) {
		SpringApplication.run(ExspringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println(testeRepository);
		throw new UnsupportedOperationException("Unimplemented method 'run'");
	}

}
