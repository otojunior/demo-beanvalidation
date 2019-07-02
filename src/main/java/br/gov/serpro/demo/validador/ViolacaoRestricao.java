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
	public static final ViolacaoRestricao VALIDACAO_OK = criarValidacaoOk();
	
	private boolean violacao;
	private String mensagem;
	private List<String> argumentos;

	/**
	 * @param mensagem
	 * @param argumentos
	 */
	private ViolacaoRestricao(String mensagem, List<String> argumentos) {
		this.violacao = true;
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
	
	/**
	 * 
	 * @return
	 */
	private static ViolacaoRestricao criarValidacaoOk() {
		ViolacaoRestricao validacaoOk = of("");
		validacaoOk.violacao = false;
		return validacaoOk;
	}
	
	@Override
	public String toString() {
		return "[mensagem=" + mensagem + "]";
	}
}
