/**
 * 
 */
package br.gov.serpro.demo.validador;

import java.util.List;
import java.util.function.Supplier;

/**
 * 
 * @author Oto Soares Coelho Junior (oto.coelho-junior@serpro.gov.br)
 *
 */
public interface ValidacaoNegocio {
	public List<List<ViolacaoRestricao>> validar();
	public List<Supplier<List<ViolacaoRestricao>>> validadores();
}
