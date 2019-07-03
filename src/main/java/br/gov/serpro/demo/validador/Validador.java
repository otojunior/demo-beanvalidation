/**
 * 
 */
package br.gov.serpro.demo.validador;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import org.springframework.stereotype.Component;

/**
 * @author Oto Soares Coelho Junior (oto.coelho-junior@serpro.gov.br)
 *
 */
@Component
public class Validador {
	public void validar(ValidacaoNegocio obj) {
		List<ViolacaoRestricao> filtrada = new ArrayList<>();
		obj.validar().forEach(filtrada::addAll);
		
		if (!filtrada.isEmpty()) {
			throw new ValidacaoNegocioException(filtrada);
		}
	}
	
	/**
	 * 
	 * @param validadores
	 * @return
	 */
	public static List<List<ViolacaoRestricao>> validadores(List<Supplier<List<ViolacaoRestricao>>> validadores) {
		List<List<ViolacaoRestricao>> violacoes = new ArrayList<>();
		validadores.forEach(supplier -> {
			violacoes.add(supplier.get());
		});
		return violacoes;
	}
}
