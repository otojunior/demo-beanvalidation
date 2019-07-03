/**
 * 
 */
package br.gov.serpro.demo.validador;

import java.util.Collections;
import java.util.List;

import lombok.Getter;

/**
 * @author Oto Soares Coelho Junior (oto.coelho-junior@serpro.gov.br)
 *
 */
@Getter
public class ViolacaoRestricao {
	private String mensagem;
	private List<String> argumentos;

	/**
	 * @param mensagem
	 * @param argumentos
	 */
	private ViolacaoRestricao(String mensagem, List<String> argumentos) {
		this.mensagem = mensagem;
		this.argumentos = argumentos;
	}
	
	/**
	 * 
	 * @param mensagem
	 * @return
	 */
	public static ViolacaoRestricao of(String mensagem) {
		return of(mensagem, Collections.emptyList());
	}
	/**
	 * 
	 * @param mensagem
	 * @param argumentos
	 * @return
	 */
	public static ViolacaoRestricao of(String mensagem, List<String> argumentos) {
		return new ViolacaoRestricao(mensagem, argumentos);
	}
	
	@Override
	public String toString() {
		return "[mensagem=" + mensagem + "]";
	}
}
