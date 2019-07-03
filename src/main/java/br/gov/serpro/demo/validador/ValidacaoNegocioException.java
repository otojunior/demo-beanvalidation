/**
 * 
 */
package br.gov.serpro.demo.validador;

import java.util.List;
import java.util.Optional;

import lombok.Getter;

/**
 * @author Oto Soares Coelho Junior (oto.coelho-junior@serpro.gov.br)
 *
 */
@Getter
public class ValidacaoNegocioException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	private List<Optional<ViolacaoRestricao>> violacoes;
	
	/**
	 * 
	 * @param violacoes
	 */
	public ValidacaoNegocioException(List<Optional<ViolacaoRestricao>> violacoes) {
		this.violacoes = violacoes;
	}
}
