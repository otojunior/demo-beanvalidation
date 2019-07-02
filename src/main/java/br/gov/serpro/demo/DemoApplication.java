package br.gov.serpro.demo;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.gov.serpro.demo.validador.AbstractValidacaoNegocio;
import br.gov.serpro.demo.validador.ValidacaoNegocioException;
import br.gov.serpro.demo.validador.Validador;
import br.gov.serpro.demo.validador.ViolacaoRestricao;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Autowired
	private Validador validador;

	@Override
	public void run(String... args) throws Exception {
		try {
			validador.validar(new DemoValidacaoNegocio());
		} catch (ValidacaoNegocioException e) {
			e.getViolacoes().forEach(System.err::println);
		}
	}
}

class DemoValidacaoNegocio extends AbstractValidacaoNegocio {
	public List<Supplier<ViolacaoRestricao>> validadores() {
		return Arrays.asList(
			this::validarRegraNegocio01,
			this::validarRegraNegocio02);
	}
	
	public ViolacaoRestricao validarRegraNegocio01() {
		// regra 1
		return ViolacaoRestricao.of("erro1");
	}
	
	public ViolacaoRestricao validarRegraNegocio02() {
		// regra 1
		return ViolacaoRestricao.of("erro2");
	}
}
