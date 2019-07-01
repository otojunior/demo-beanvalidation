package br.gov.serpro.demo;

import javax.validation.Validator;
import javax.validation.constraints.AssertTrue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	@Autowired
	private Validator validator;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		DemoService service = new DemoService();
		validator.validate(service);
	}
}

class DemoService {
	@AssertTrue
	public boolean isDoSomeStuff() {
		System.out.println("isDoSomeStuff called");
		return true;
	}
}