package br.gov.serpro.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import br.org.otojunior.validadornegocio.validador.SpringBootValidadorApplication;

/**
 * 
 * @author Oto Soares Coelho Junior (otojunior@gmail.com)
 *
 */
@SpringBootApplication
@ComponentScan(basePackageClasses = {
	SpringBootValidadorApplication.class,
	DemoApplication.class})
public class DemoApplication {
	/**
	 * 
	 * @param args
	 */
	public static void main(String... args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
