package br.gov.serpro.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.gov.serpro.demo.validador.ValidacaoNegocioException;

/**
 * 
 * @author Oto Soares Coelho Junior (oto.coelho-junior@serpro.gov.br)
 *
 */
@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	@Autowired
	private DemoService service;

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	/**
	 * 
	 */
	@Override
	public void run(String... args) throws Exception {
		try {
			service.executar();
		} catch (ValidacaoNegocioException e) {
			e.getViolacoes().forEach(System.err::println);
		}
	}
}
