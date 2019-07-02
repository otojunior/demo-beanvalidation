/**
 * 
 */
package br.gov.serpro.demo.validador;

import java.util.ArrayList;
import java.util.List;
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
		List<ViolacaoRestricao> violacoes = obj.validar();
		violacoes = violacoes
			.stream()
			.filter(ViolacaoRestricao::isViolacao)
			.collect(Collectors.toList());
		
		if (!violacoes.isEmpty()) {
			throw new ValidacaoNegocioException(violacoes);
		}
		
	}
	
	public static List<ViolacaoRestricao> validadores(List<Supplier<ViolacaoRestricao>> validadores) {
		List<ViolacaoRestricao> violacoes = new ArrayList<>();
		validadores.forEach(supplier -> {
			violacoes.add(supplier.get());
		});
		return violacoes;
	}
}
