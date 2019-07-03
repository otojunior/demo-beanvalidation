/**
 * 
 */
package br.gov.serpro.demo.validador;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

/**
 * @author Oto Soares Coelho Junior (oto.coelho-junior@serpro.gov.br)
 *
 */
@Component
public class Validador {
	public void validar(ValidacaoNegocio obj) {
		List<Optional<ViolacaoRestricao>> violacoes = obj.validar();
		violacoes = violacoes
			.stream()
			.filter(Optional::isPresent)
			.collect(Collectors.toList());
		
		if (!violacoes.isEmpty()) {
			throw new ValidacaoNegocioException(violacoes);
		}
		
	}
	
	public static List<Optional<ViolacaoRestricao>> validadores(List<Supplier<Optional<ViolacaoRestricao>>> validadores) {
		List<Optional<ViolacaoRestricao>> violacoes = new ArrayList<>();
		validadores.forEach(supplier -> {
			violacoes.add(supplier.get());
		});
		return violacoes;
	}
}
